import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Card from 'react-bootstrap/Card';
import InvoiceItem from './InvoiceItem';
import InvoiceModal from './InvoiceModal';
import InputGroup from 'react-bootstrap/InputGroup';
import axios from 'axios';
import { getCurrentUserDetail } from '../Auth';



class InvoiceForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isOpen: false,
      currency: '₹',
      currentDate: '',
      invoiceNumber: 1,
      dateOfIssue: '',
      billTo: '',
      billToEmail: '',
      billToAddress: '',
      billFrom: '',
      billFromEmail: '',
      billFromAddress: '',
      notes: '',
      total: '0.00',
      subTotal: '0.00',
      taxRate: '',
      taxAmmount: '0.00',
      discountRate: '',
      discountAmmount: '0.00',
      buy_button_color : "primary",
      sell_button_color : "secondary",
      jwt :"",
      valueOfDescription:"",
      responce: ""
    };
    this.state.items = [
      {
        id: 0,
        name: '',
        description: '',
        price: '1.00',
        quantity: 1
      }
    ];
    this.editField = this.editField.bind(this);
    this.timeoutIdRef = React.createRef();
  }

  componentDidMount(prevProps) {
    this.handleCalculateTotal()
  }
  handleRowDel(items) {
    var index = this.state.items.indexOf(items);
    this.state.items.splice(index, 1);
    this.setState(this.state.items);
  };
  handleAddEvent(evt) {
    var id = (+ new Date() + Math.floor(Math.random() * 999999)).toString(36);
    var items = {
      id: id,
      name: '',
      price: '1.00',
      description: '',
      quantity: 1
    }
    this.state.items.push(items);
    this.setState(this.state.items);
  }

  handleCalculateTotal() {
    var items = this.state.items;
    var subTotal = 0;

    items.map(function(items) {
      subTotal= parseFloat(parseFloat(subTotal) + parseFloat((parseFloat(items.price) * parseInt(items.quantity)))); 
    });

    this.setState({
      subTotal: parseFloat(subTotal).toFixed(2)     
    }, 
    () => {
      this.setState({
        taxAmmount: parseFloat(parseFloat(subTotal) * (this.state.taxRate / 100)).toFixed(2)
      }, 
      () => {
        this.setState({
          discountAmmount: parseFloat(parseFloat(subTotal) * (this.state.discountRate / 100)).toFixed(2)
        }, 
        () => {
          this.setState({
            total: ((subTotal - this.state.discountAmmount) + parseFloat(this.state.taxAmmount))
            
          });
        });
      });
    });
  };

  onItemizedItemEdit(evt) {
    var item = {
      id: evt.target.id,
      name: evt.target.name,
      value: evt.target.value
    };
    var items = this.state.items.slice();
    var newItems = items.map(function(items) {
      for (var key in items) {
        if (key == item.name && items.id == item.id) {
          items[key] = item.value;
        }
      }
      return items;
    });
    this.setState({items: newItems});
    this.handleCalculateTotal();
  };

  editField = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
    this.handleCalculateTotal();
  };

  // onCurrencyChange = (selectedOption) => {
  //   this.setState(selectedOption);
  // };
  openModal = (event) => {
    event.preventDefault()
    this.handleCalculateTotal()
    this.setState({isOpen: true})

  };

  closeModal = (event) => this.setState({isOpen: false});
 

  buy_button=()=>{
 
    this.setState( {
                  sell_button_color : "primary",
                  buy_button_color : "secondary",
                  billTo: 'harish',
                  billToEmail: 'harish@gmail.com',
                  billToAddress: 'chamanshing bag road ,ballia',
                  billFrom: '',
                  billFromEmail: '',
                  billFromAddress: ''
                  } )

                  var myInput1 = document.getElementById('billto');
                  myInput1.readOnly= true;
                  var myInput2 = document.getElementById('billFrom');
                  myInput2.readOnly= false;

  
  }

  sell_button=()=>{

    this.setState( {
                     sell_button_color : "secondary" ,
                     buy_button_color : "primary",
                     billFrom: 'harish',
                     billFromEmail: 'harish@gmail.com',
                     billFromAddress: 'chamanshing bag road ,ballia',
                     billTo: '',
                     billToEmail: '',
                     billToAddress: '',
  }  )

  var myInput1 = document.getElementById('billFrom');
  myInput1.readOnly= true;
  var myInput2 = document.getElementById('billto');
  myInput2.readOnly= false;
   
  }
/////////////////////////////////////////////api call to search///////////
  debounce = (func, delay) => {
    return function () {
      const context = this;  
      const args = arguments;
      clearTimeout(context.timeoutIdRef.current);
      context.timeoutIdRef.current = setTimeout(() => {
        func.apply(context, args);
      }, delay);
    };
  };

search=(value,args)=>{
 
  const obj=getCurrentUserDetail(); 
  this.state.jwt=obj.jwtToken;
//  let responceval=this;
  
  axios.get('http://localhost:8082/lock/Search/'+args+'/'+value,{
      headers: {
          Authorization:  `Bearer ${this.state.jwt}`
        }
  })
  .then((response) =>{
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

 debouncedSearch = this.debounce(this.search,500);

  runBillTo=(event)=>{
    const { value } = event.target;
    const urlVal='c';
    this.debouncedSearch(value,urlVal);

    if (!event.keyCode) { // OR: if (e.keyCode === undefined)

   axios.get('http://localhost:8082/lock/Search/cs/'+value,{
       headers: {
           Authorization:  `Bearer ${this.state.jwt}`
         }
   }).then((response) =>{
          
           this.state.billToEmail="("+response.data.customer_id+") "+response.data.address;
           this.state.billToAddress=response.data.city+" ("+response.data.customer_phone_no+")";

         }
      ).catch(error=>{
      console.log(error);
      console.log("hello wrong  XXXXXXXXXXXXXXX");
    
   })}

    
  }

  runBillFrom=(event)=>{
    const { value } = event.target;
    const urlVal='s';
    this.debouncedSearch(value,urlVal);

    if (!event.keyCode) { // OR: if (e.keyCode === undefined)
     
    axios.get('http://localhost:8082/lock/Search/ss/'+value,{
      headers: {
          Authorization:  `Bearer ${this.state.jwt}`
        }
  }).then((response) =>{

        
          this.state.billFromEmail="("+response.data.seller_id+") "+response.data.address;
          this.state.billFromAddress=response.data.city+" ("+response.data.seller_phone_no+")";

        }
     ).catch(error=>{
     console.log(error);
     console.log("hello wrong  XXXXXXXXXXXXXXX");
   
  })}
   
  }

///////////////////////////////////////////////////////////api call to search/////////
  render() {
    return (<Form onSubmit={this.openModal}>

      
      <Row>
        <Col md={8} lg={9}>
          <Card className="p-4 p-xl-5 my-3 my-xl-4">
            <div className="d-flex flex-row align-items-start justify-content-between mb-3">
              <div class="d-flex flex-column">
                <div className="d-flex flex-column">
                  <div class="mb-2">
                    <span className="fw-bold">Current&nbsp;Date:&nbsp;</span>
                    <span className="current-date">{new Date().toLocaleDateString()}</span>
                  </div>
                </div>

              </div>
              <div className="d-flex flex-row align-items-center">
                <span className="fw-bold me-2">Invoice&nbsp;Number:&nbsp;</span>
                <Form.Control type="number" value={this.state.invoiceNumber} name={"invoiceNumber"} onChange={(event) => this.editField(event)} min="1" style={{
                    maxWidth: '70px'
                  }} required="required"/>
              </div>
            </div>
            <hr className="my-4"/>
            <Row className="mb-5">
              <Col >
                <Form.Label  className="fw-bold">Bill to:</Form.Label>
                <Form.Control id="billto"  placeholder={"Who is this invoice to?"} rows={3} value={this.state.billTo} type="text" name="billTo" className="my-2" onChange={(event) => this.editField(event)} onKeyUp={this.runBillTo} autoComplete="name" list='suggestionList' required="required"/>
                <Form.Control  placeholder={"Email address"} value={this.state.billToEmail} type="email" name="billToEmail" className="my-2" onChange={(event) => this.editField(event)} autoComplete="email" readonly="readonly" required="required"/>
                <Form.Control  placeholder={"Billing address"} value={this.state.billToAddress} type="text" name="billToAddress" className="my-2" autoComplete="address" onChange={(event) => this.editField(event)} readonly="readonly"  required="required"/>
              </Col>
              <Col>
                <Form.Label className="fw-bold">Bill from:</Form.Label>
                <Form.Control id="billFrom"  placeholder={"Who is this invoice from?"} rows={3} value={this.state.billFrom} type="text" name="billFrom" className="my-2" onChange={(event) => this.editField(event)} onKeyUp={this.runBillFrom} autoComplete="name" list='suggestionList' required="required"/>
                <Form.Control  placeholder={"Email address"} value={this.state.billFromEmail} type="email" name="billFromEmail" className="my-2" onChange={(event) => this.editField(event)} autoComplete="email" readonly="readonly" required="required"/>
                <Form.Control  placeholder={"Billing address"} value={this.state.billFromAddress} type="text" name="billFromAddress" className="my-2" autoComplete="address" onChange={(event) => this.editField(event)} readonly="readonly"  required="required"/>
              </Col>

            <datalist id='suggestionList'>
            {
              Object.keys(this.state.responce).map((key) => {
                   return( <option key={key} value={this.state.responce[key]}>{this.state.responce[key]}</option>)
                          //console.log(key,this.state.responce[key])
                        })
            }
          </datalist>

            </Row>

            <InvoiceItem onItemizedItemEdit={this.onItemizedItemEdit.bind(this)} onRowAdd={this.handleAddEvent.bind(this)} onRowDel={this.handleRowDel.bind(this)} currency={this.state.currency} items={this.state.items}/>
            
            <Row className="mt-4 justify-content-end">
              <Col lg={6}>
                <div className="d-flex flex-row align-items-start justify-content-between">
                  <span className="fw-bold">Subtotal:
                  </span>
                  <span>{this.state.currency}
                    {this.state.subTotal}</span>
                </div>
                <div className="d-flex flex-row align-items-start justify-content-between mt-2">
                  <span className="fw-bold">Discount:</span>
                  <span>
                    <span className="small ">({this.state.discountRate || 0}%)</span>
                    {this.state.currency}
                    {this.state.discountAmmount || 0}</span>
                </div>
                <div className="d-flex flex-row align-items-start justify-content-between mt-2">
                  <span className="fw-bold">Tax:
                  </span>
                  <span>
                    <span className="small ">({this.state.taxRate || 0}%)</span>
                    {this.state.currency}
                    {this.state.taxAmmount || 0}</span>
                </div>
                <hr/>
                <div className="d-flex flex-row align-items-start justify-content-between" style={{
                    fontSize: '1.125rem'
                  }}>
                  <span className="fw-bold">Total  :
                  </span>
                  <span className="fw-bold">{this.state.currency}
                    {this.state.total || 0}</span>
                </div>
              </Col>
            </Row>
            <hr className="my-4"/>
            <Form.Label className="fw-bold">Notes:</Form.Label>
            <Form.Control placeholder="Thanks for your business!" name="notes" value={this.state.notes} onChange={(event) => this.editField(event)} as="textarea" className="my-2" rows={1}/>
          </Card>
        </Col>
       

        <Col md={4} lg={3}>
          <div className="sticky-top pt-md-3 pt-xl-4">
           

          <Button variant={this.state.buy_button_color}  onClick={this.buy_button}    className="d-block w-100 my-4"> Buy</Button>
            <Button variant={this.state.sell_button_color} onClick={this.sell_button}    className="d-block w-100 my-4 ">sell </Button>

          
            <Form.Group className="my-3">
              <Form.Label className="fw-bold">Tax rate:</Form.Label>
              <InputGroup className="my-1 flex-nowrap">
                <Form.Control name="taxRate" type="number" value={this.state.taxRate} onChange={(event) => this.editField(event)} className="bg-white border" placeholder="0.0" min="0.00" step="0.01" max="100.00"/>
                <InputGroup.Text className="bg-light fw-bold text-secondary small">
                  %
                </InputGroup.Text>
              </InputGroup>
            </Form.Group>


            <Form.Group className="my-3">
              <Form.Label className="fw-bold">Discount rate:</Form.Label>
              <InputGroup className="my-1 flex-nowrap">
                <Form.Control name="discountRate" type="number" value={this.state.discountRate} onChange={(event) => this.editField(event)} className="bg-white border" placeholder="0.0" min="0.00" step="0.01" max="100.00"/>
                <InputGroup.Text className="bg-light fw-bold text-secondary small">
                  %
                </InputGroup.Text>
              </InputGroup>
            </Form.Group>

            <Row>

   

            </Row>

            <Card className="p-4 p-xl-5 my-3 my-xl-4 shadow p-3 mb-5 bg-white rounded">
            <Row className="justify-content-between ">
              <Col lg={10}>
                <div className="d-flex  justify-content-between">
                  <span className="fw-bold">Subtotal:
                  </span>
                  <span>{this.state.currency}
                    {this.state.subTotal}</span>
                </div>
                <div className="d-flex flex-row align-items-start justify-content-between mt-2">
                  <span className="fw-bold">Discount:</span>
                  <span>
                    <span className="small ">({this.state.discountRate || 0}%)</span>
                    {this.state.currency}
                    {this.state.discountAmmount || 0}</span>
                </div>
                <div className="d-flex flex-row align-items-start justify-content-between mt-2">
                  <span className="fw-bold">Tax:
                  </span>
                  <span>
                    <span className="small ">({this.state.taxRate || 0}%)</span>
                    {this.state.currency}
                    {this.state.taxAmmount || 0}</span>
                </div>
                <hr/>
                <div className="d-flex flex-row align-items-start justify-content-between" style={{
                    fontSize: '1.125rem'
                  }}>
                  <span className="fw-bold">Total :
                  </span>
                  <span className="fw-bold">{this.state.currency}
                    {this.state.total || 0}</span>
                </div>
              </Col>
            </Row>
            </Card>
            <InvoiceModal showModal={this.state.isOpen} closeModal={this.closeModal} info={this.state} items={this.state.items} currency={this.state.currency} subTotal={this.state.subTotal} taxAmmount={this.state.taxAmmount} discountAmmount={this.state.discountAmmount} total={this.state.total}/>
            <Button variant="primary" type="submit" className="d-block w-100">Review Invoice</Button>
          
  
          </div>
        </Col>
      </Row>
    </Form>)
  }
}

export default InvoiceForm;
