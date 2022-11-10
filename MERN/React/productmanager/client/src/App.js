import './App.css';
import Main from "./views/Main";
import CreateProduct from './components/CreateProduct';
import OneProduct from "./components/OneProduct";
import DisplayAll from './components/DisplayAll';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import UpdateProduct from './components/UpdateProduct';

function App() {
  return (
    <BrowserRouter>
            <div className="App">
                <Routes>
                    <Route path="/" element={<Main/>} />
                    <Route path="/product/:id" element={<OneProduct/>}/> 
                    <Route path="/product/edit/:id" element={<UpdateProduct />} />
                </Routes>
            </div>
        </BrowserRouter>
  );
}

export default App;
