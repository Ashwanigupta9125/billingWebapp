import { useState } from "react";
import Form from 'react-bootstrap/Form';

const Analytics = () => {
    const [startDate, setstartDate] = useState(new Date().toLocaleDateString());
    


    function changeInStartingDate(e){
        console.log("hello 1")
        
        console.log("hello 2")
    }
   
    return (
        <div className='main_loggin' >
            
                <div className="d-flex flex-row align-items-center mx-3">
                  <span className="fw-bold d-block me-2">Starting&nbsp;Date:</span>
               
                  <Form.Control type="date" name={"dateOfIssue"} onChange={(event) =>changeInStartingDate(event)} style={{
                      maxWidth: '150px'
                    }} required="required"/>
                </div>

                <div className="d-flex flex-row align-items-center mx-3">
                  <span className="fw-bold d-block me-2">End&nbsp;Date:</span>
                
               
                  <Form.Control type="date" name={"dateOfIssue"} onChange={(event) =>changeInStartingDate(event)} style={{
                      maxWidth: '150px'
                    }} required="required"/>
                </div>

        </div>
    );
};

export default Analytics;