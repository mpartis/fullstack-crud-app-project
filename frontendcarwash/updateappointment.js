const updateForm = document.getElementById('update-form');
const updateMessage = document.getElementById('update-message');

updateForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const appointmentId = document.getElementById('appointment-id').value;
    const appointmentName = document.getElementById('appointment-name').value;
    const appointmentEmail = document.getElementById('appointment-email').value;
    const appointmentDate = document.getElementById('appointment-date').value;
    
    const queryParams = new URLSearchParams({
        name: appointmentName,
        mail: appointmentEmail,
        date: appointmentDate
    });

    fetch(`http://localhost:8080/api/v1/appointment/${appointmentId}?${queryParams}`, {
        method: 'PUT'
    })
    .then((response) => {
        if (response.ok) {
            updateMessage.textContent = `Appointment with ID ${appointmentId} has been updated`;
        } else {
            updateMessage.textContent = `Error updating appointment with ID ${appointmentId}`;
        }   
    })
    .catch((error) => {
        console.error(error);
        updateMessage.textContent = 'An error occurred while updating the appointment';
    });
});