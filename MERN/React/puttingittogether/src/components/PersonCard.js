import React, {useState} from 'react'


const PersonCard = (props) => {
    const [initialAge,setAgeIncrease]= useState(props.age)
return (
    <div>
        <h3>{props.lastName} , {props.firstName}</h3>
        <p>Age:{initialAge}</p>
        <p>Hair Color: {props.hairColor}</p>
        <button onClick = {() => setAgeIncrease(initialAge + 1)}>Increase Age</button>

    </div>
)
}

export default PersonCard