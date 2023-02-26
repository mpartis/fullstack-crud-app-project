const deleteForm = document.getElementById('delete-form');
const deleteMessage = document.getElementById('delete-message');

deleteForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const appointmentId = document.getElementById('appointment-id').value;

    fetch(`http://localhost:8080/api/v1/appointment/${appointmentId}`, {
        method: 'DELETE'
    })
    .then((response) => {
        if (response.ok) {
            deleteMessage.textContent = `Appointment with ID ${appointmentId} has been deleted`;
        } else {
            deleteMessage.textContent = `Error deleting appointment with ID ${appointmentId}`;
        }   
    })
    .catch((error) => {
        console.error(error);
        deleteMessage.textContent = 'An error occurred while deleting the appointment';
    });
});