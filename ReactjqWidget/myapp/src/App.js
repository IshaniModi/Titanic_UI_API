import React, { Component } from 'react';
import Passenger from './passenger'
import Chart from './chart'
import { BrowserRouter as Router, Route} from 'react-router-dom';

class App extends Component {
  render() {
    console.log("Host URL"+process.env.PUBLIC_URL);
    return (
      <Router basename={process.env.PUBLIC_URL}>
        <div className="App">            
         <Route exact path='/passenger' component={Passenger} />
         <Route exact path='/chart' component={Chart} />
        </div>
    </Router>
    );
  }
}

export default App;
