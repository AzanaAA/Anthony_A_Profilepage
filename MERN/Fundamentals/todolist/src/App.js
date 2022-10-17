import React, { useState } from "react";
import './App.css';
import Form from "./components/Form"
import Index from './components/Index';

function App() {
  const [todoList, setTodoList] = useState([]);
  return (

<div className="App">
      <Form todoList={todoList} setTodoList={setTodoList} />
      <Index todoList={todoList} setTodoList={setTodoList} />
    </div>
  );
}


export default App;
