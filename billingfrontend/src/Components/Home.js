import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Sidebar from '../Components/Sidebar';
import Dashboard from '../pages/Dashboard.jsx';
import About from '../pages/About.jsx';
import Analytics from '../pages/Analytics.jsx';
import Comment from '../pages/Comment.jsx';
import Product from '../pages/Product.jsx';
import ProductList from '../pages/ProductList.jsx';
import Logging from './Logging';
import Userdashboard from './Userdashboard';
import Privateroute from './Privateroute';
import Logout from './Logout';


export default function Home() {
  return (
    <>
    <div>
    <BrowserRouter>
      <Sidebar>
        <Routes>
        <Route path="/" element={<Dashboard />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/about" element={<About />} />
          <Route path="/comment" element={<Comment />} />
          <Route path="/analytics" element={<Analytics />} />
          <Route path="/product" element={<Product />} />
          <Route path="/login" element={<Logging />} />
          
          <Route path="/logout" element={<Logout />} />
          <Route path="/user" element={<Privateroute />} >

           <Route path="userdashboard" element={<Userdashboard />} />
          </Route>
                  
  

          <Route path="/productList" element={<ProductList />} />
        </Routes>
      </Sidebar>
    </BrowserRouter>
    </div>
    </>
  )
}
