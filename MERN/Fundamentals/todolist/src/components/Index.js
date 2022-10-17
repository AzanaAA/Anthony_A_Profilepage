import React, {useState} from 'react'

const Index = (props) => {
    const { todoList, setTodoList } = props;
    const handleCompleted = (todo) => {
        todo.markedDelete = !todo.markedDelete;
    setTodoList([...todoList]);
    };



    const completed = (markedDelete) => {
        if (markedDelete === true) {
        return "completed";
        } else {
        return "notCompleted";
        }
    };

    const deleteButton = (idFromBelow) => {
        setTodoList(
            todoList.filter((todo, index) => {
                return todo.id !== idFromBelow;
            })
        );
        };

    return (
    <div>
        {todoList.map((todo, index) => (
            <div className={completed(todo.markedDelete)} key={todo.id}>
            {" "}
            {<p>{todo.content}</p>}
            {<input type="checkbox" onChange={() => handleCompleted(todo)} />}
            <button onClick={() => deleteButton(todo.id)}>Delete</button>{" "}
        </div> ))}
    </div>
    )
}

export default Index