import '../CSS/Signup.css';

function Signup() {
    function register_admin() {
        let name = document.getElementById("name").value;
        let email = document.getElementById("email").value;
        let password = document.getElementById("password").value;

        console.log(name, email, password)

        let admin = {
            name: name,
            email: email,
            password: password
        }

        api_call_to_register_admin(admin)
    }

    async function api_call_to_register_admin(admin) {
        try {
            const response = await fetch('http://localhost:8080/register_admin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(admin)
            });

            let response_text = await response.text();
            console.log(response_text);
        } catch (error) {
            console.log(error)
        }
    }

    return (
        <>
            <div className='signup_parent'>
                <div className='signup_page'>
                    <h1>SIGNUP</h1>
                    <input type="text" placeholder='Enter your name' id="name"></input>
                    <input type="email" placeholder='Enter your email' id="email"></input>
                    <input type="password" placeholder='Enter your password' id="password"></input>

                    <button onClick={register_admin}>REGISTER</button>
                </div>
            </div>
        </>
    );
}

export default Signup;
