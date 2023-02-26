fetch('http://localhost:8080/api/v1/appointment')
            .then(res => {
                return res.json();
            })
            .then(data => {
                data.forEach(appointment => {
                    const markup = `<li>ID: ${appointment.id}<br>Name: ${appointment.name}<br>Mail: ${appointment.mail}<br>Date: ${appointment.date}<br>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br></li>`;

                    document.querySelector('ul').insertAdjacentHTML('beforeend', markup);
                })
            })
            .catch(error => console.log(error));