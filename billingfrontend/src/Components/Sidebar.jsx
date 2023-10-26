import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
    FaTh,
    FaBars,
    FaUserAlt,
    FaRegChartBar,
    FaCommentAlt,
    FaShoppingBag,
    FaThList,
    FaGrinAlt,
    FaGrinBeamSweat
}from "react-icons/fa";


import { NavLink } from 'react-router-dom';


const Sidebar = ({children}) => {
    const[isOpen ,setIsOpen] = useState(false);
    const toggle = () => setIsOpen (!isOpen);
    const menuItem=[
        {
            path:"/",
            name:"Generate Bill",
            icon:<FaTh/>
        },
        {
            path:"/about",
            name:"Customer Detail",
            icon:<FaUserAlt/>
        },
        {
            path:"/analytics",
            name:"Analytics",
            icon:<FaRegChartBar/>
        },
        {
            path:"/product",
            name:"Product",
            icon:<FaShoppingBag/>
        },
        {
            path:"/productList",
            name:"Product List",
            icon:<FaThList/>
        },
        {
            path:"/comment",
            name:"Comment",
            icon:<FaCommentAlt/>
        }

        
    ]


    const menuItemSec=[
        {
            path:"/login",
            name:"Loggin",
            icon:<FaGrinAlt/>
        },
        {
            path:"/logout",
            name:"Loggout",
            icon:<FaGrinBeamSweat/>
        }
     
    ]

    return (
        <div className="container_navbar">
           <div style={{width: isOpen ? "200px" : "50px"}} className="sidebar">
               <div className="top_section">
                   <h1 style={{display: isOpen ? "block" : "none"}} className="logo">Logo</h1>
                   <div style={{marginLeft: isOpen ? "50px" : "0px"}} className="bars">
                       <FaBars onClick={toggle}/>
                   </div>
               </div>
               {
                   menuItem.map((item, index)=>(
                       <NavLink to={item.path} key={index} className="link" activeclassName="active">
                           <div className="icon">{item.icon}</div>
                           <div style={{display: isOpen ? "block" : "none"}} className="link_text">{item.name}</div>
                       </NavLink>
                   ))
               }


               {   
            
                   menuItemSec.map((item, index)=>(
                    <nav>
                       <NavLink to={item.path} key={index} className="link" activeclassName="active">
                           <div className="icon">{item.icon}</div>
                           <div style={{display: isOpen ? "block" : "none"}} className="link_text " >{item.name}</div>
                       </NavLink>
                       </nav>
                   ))
               
               }

           </div>
           <main>{children}</main>
        </div>
    );
};

export default Sidebar;