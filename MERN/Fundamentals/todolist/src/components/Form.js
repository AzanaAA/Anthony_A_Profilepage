import React, {useState} from 'react'

const Form = (props) => {
    const [todoItem, setTodoItem]= useState("");
    const {todoList, setTodoList}= props;

    const submitHandler = (e) => {
        e.preventDefault();
        setTodoList([
            ...todoList,{
                content: todoItem,markedDelete: false,
                id: Math.floor(Math.random() * 100000000).toString(),
            },
        ]);
        setTodoItem("");
        };
            
    
    return (
        <div>
            <form onSubmit={submitHandler}>
                <input
                value={todoItem}
                onChange={(e) => setTodoItem(e.target.value)}
                type="text"/>
                <button>Add</button>
            </form>
        </div>
    )
}


export default Form