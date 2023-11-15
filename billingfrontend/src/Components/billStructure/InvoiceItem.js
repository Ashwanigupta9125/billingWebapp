import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { BiTrash } from "react-icons/bi";
import EditableField from './EditableField';
import axios from 'axios';
import { getCurrentUserDetail } from '../Auth';

class InvoiceItem extends React.Component {

  // constructor(props) {
  //   super(props);
  //   //this.state.suggestions = ["asdasd"]; 
    
  // }
  
  
  render() {
    
    var onItemizedItemEdit = this.props.onItemizedItemEdit;
    var currency = this.props.currency;
    var rowDel = this.props.onRowDel;
    var itemTable = this.props.items.map(function(item) {
      return (
        <ItemRow onItemizedItemEdit={onItemizedItemEdit} item={item} onDelEvent={rowDel.bind(this)} key={item.id} currency={currency}/>
      )
    });
  

    return (
      <div>
        <Table>
          <thead>
            <tr>
              <th>ITEM</th>
              <th>QTY</th>
              <th>PRICE/RATE</th>
              <th className="text-center">ACTION</th>
            </tr>
          </thead>
          <tbody>
            {itemTable}
          </tbody>
        </Table>
        <Button className="fw-bold" onClick={this.props.onRowAdd}>Add Item</Button>
      </div>
    );

  }

}
class ItemRow extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      query: '',
      q1 : null,
      jwt :"",
      valueOfDescription:"",
      responce: ""
    };
    
    //this.state.responce=["this is empty array"];
    this.timeoutIdRef = React.createRef();
  }

   search=(value,args)=>{

    const obj=getCurrentUserDetail(); 
    this.state.jwt=obj.jwtToken;
  //  let responceval=this;
    
    axios.get('http://localhost:8082/lock/Search/p/'+value,{
        headers: {
            Authorization:  `Bearer ${this.state.jwt}`
          }
    })
    .then((response) =>{
          
            console.log("logincccccccccccccccccc")
          this.setState({responce: response.data})
          Object.keys(this.state.responce);


          }
       )
    .catch(error=>{
       console.log(error);
       console.log("hello wrong  XXXXXXXXXXXXXXX");
       console.log('http://localhost:8082/lock/Search/'+value)
    })
   
  }
  
  debounce = (func, delay) => {
    return function () {
      const context = this;
      const args = arguments;
      clearTimeout(context.timeoutIdRef.current);
      context.timeoutIdRef.current = setTimeout(() => {
        func.apply(context, args,5000);
      }, delay);
    };
  };

   debouncedSearch = this.debounce(this.search, 500);

   Run = (event) => {
    const { value } = event.target;
    this.setState({ query: value });
    this.debouncedSearch(value);

    if (!event.keyCode) { // OR: if (e.keyCode === undefined)
       
    axios.get('http://localhost:8082/lock/Search/ps/'+value,{
        headers: {
            Authorization:  `Bearer ${this.state.jwt}`
          }
    })
    .then((response) =>{
            this.state.valueOfDescription="Id -"+response.data.product_id+" Catagory-"+response.data.product_catagory;
          }
       )
    .catch(error=>{
       console.log(error);
       console.log("hello wrong  XXXXXXXXXXXXXXX");
     
    })



    }

  };
  onDelEvent() {
    this.props.onDelEvent(this.props.item);
  }


  render() {

    //const { query } = this.state;

    return (
      <tr>
        <td style={{width: '100%'}}>
          <EditableField
            onItemizedItemEdit={this.props.onItemizedItemEdit}
           // Run={Run(this.props.item.name)}
           Run={this.Run}
            cellData={{
            type: "text",
            name: "name",
            suggestion: `suggestion-${this.props.item.id}`,
            placeholder: "Item name",
            value: this.props.item.name,
            id: this.props.item.id,
          } 
          }/>
          <EditableField
            onItemizedItemEdit={this.props.onItemizedItemEdit}
            cellData={{
            type: "text",
            name: "description",
            placeholder: "Item description",
            value: this.state.valueOfDescription,
            id: this.props.item.id,
            
          }}/>
          <datalist id={`suggestion-${this.props.item.id}`}>
            {
              Object.keys(this.state.responce).map((key) => {
                return( <option key={key} value={this.state.responce[key]}>{this.state.responce[key]}</option>)
                })
            }
          </datalist>

        </td>
        <td style={{minWidth: '70px'}}>
          <EditableField
          onItemizedItemEdit={this.props.onItemizedItemEdit}
          cellData={{
            type: "number",
            name: "quantity",
            min: 1,
            step: "1",
            value: this.props.item.quantity,
            id: this.props.item.id,
          }}/>
        </td>
        <td style={{minWidth: '130px'}}>
          <EditableField
            onItemizedItemEdit={this.props.onItemizedItemEdit}
            cellData={{
            leading: this.props.currency,
            type: "number",
            name: "price",
            min: 1,
            step: "0.01",
            presicion: 2,
            textAlign: "text-end",
            value: this.props.item.price,
            id: this.props.item.id,
          }}/>
        </td>
        <td className="text-center" style={{minWidth: '50px'}}>
          <BiTrash onClick={this.onDelEvent.bind(this)} style={{height: '33px', width: '33px', padding: '7.5px'}} className="text-white mt-1 btn btn-danger"/>
        </td>
      </tr>
    );

  }

}

export default InvoiceItem;
