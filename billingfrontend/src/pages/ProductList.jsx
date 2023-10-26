import React from 'react';
import { getCurrentUserDetail } from '../Components/Auth';
import axios from 'axios';

const ProductList = () => {

    const run =()=>{
      
     const obj=getCurrentUserDetail();   
      let jwt=obj.jwtToken;
    // let user={"Authorization" : jwt}
     //console.log(user);
    //  axios.get('http://localhost:8082/lock/test',user)
    //  .then(
    //     function (response) {

           
    //          console.log("logincccccccccccccccccc")
    //          console.log(response)
 
    //        }
    //     )
    //  .catch(error=>{
    //     console.log(error);
    //     console.log("hello wrong  XXXXXXXXXXXXXXX");
    //  })


    axios.get('http://localhost:8082/lock/test',{
        headers: {
            Authorization:  `Bearer ${jwt}`
          }
    })
    .then(
       function (response) {

          
            console.log("logincccccccccccccccccc")
            console.log(response)

          }
       )
    .catch(error=>{
       console.log(error);
       console.log("hello wrong  XXXXXXXXXXXXXXX");
    })

     
    }

    return (
        <div>
            <h1>product list page</h1>

            <button type="button" onClick={run} class="btn btn-light">Light</button>
        </div>
    );
};

export default ProductList;