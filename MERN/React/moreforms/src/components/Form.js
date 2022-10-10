import React, {useState} from 'react'

const Form = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const createUser = (e) =>{
        e.preventDefault();
        const newUser={firstName,lastName,email,password,confirmPassword};
        setFirstName("");
        setLastName("");
        setEmail("");
        setPassword("");
        setConfirmPassword("");
    };


return (
    <div>
        <form onSubmit = {createUser}>
        <div>
            <label>First Name:</label>
            <input type="text" value={firstName} onChange={(e)=> setFirstName(e.target.value)} />
        </div>
        {firstName.length < 3 && firstName.length > 0 ? (
            <p>First Name must be at least 3 characters</p>
        ) : null}

        <div>
            <label>Last Name:</label>
            <input type="text" value={lastName} onChange={(e)=> setLastName(e.target.value)} />
        </div>
        {lastName.length < 3 && lastName.length > 0 ? (
            <p>Last Name must be at least 3 characters</p>
        ) : null}

        <div>
            <label>Email:</label>
            <input type="text" value={email} onChange={(e)=> setEmail(e.target.value)} />
        </div>
        {email.length < 2 ? <p>Email must be at least 2 characters</p> : null}

        <div>
            <label>Password:</label>
            <input type="text" value={password} onChange={(e)=> setPassword(e.target.value)} />
        </div>
        {password.length < 8 ? (
            <p>Password must be at least 8 characters</p>
        ) : null}

        <div>
            <label>Confirm Password:</label>
            <input type="text" value={confirmPassword} onChange={(e)=> setConfirmPassword(e.target.value)} />
        </div>
        {confirmPassword !== password ? <p>Passwords must match</p> : null}
        </form>


        
    </div>
)
}



export default Form