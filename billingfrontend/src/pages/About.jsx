import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';


const About = () => {
    return (
        <div>
            
      <Form>
      <fieldset >
        <Form.Group className="mb-3">
          <Form.Label htmlFor="disabledTextInput">Disabled input</Form.Label>
          <Form.Control id="disabledTextInput" placeholder="Disabled input" />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Label htmlFor="disabledSelect">Disabled select menu</Form.Label>
          <Form.Select id="disabledSelect">
            <option>Disabled select</option>
            <option>Option 1</option>
            <option>Option 2</option>
            <option>Option 3</option>
            <option>Option 4</option>
          </Form.Select>
        </Form.Group>
        <Button type="submit">Submit</Button>
      </fieldset>
    </Form>
           
        </div>
    );
};

export default About;