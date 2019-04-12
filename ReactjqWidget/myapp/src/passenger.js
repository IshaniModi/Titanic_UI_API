import React, { Component } from 'react';
import axios from 'axios';
import JqxGrid, { jqx } from './assets/jqwidgets-react/react_jqxgrid';
class Passenger extends Component {
   
    constructor(props) {
        super(props);
          this.state = {
          passengerList:[],
          columns:          [
              { text: 'name1',columntype: 'textbox', datafield: 'name1', width: 120 },
              { text: 'name2', datafield: 'name2', columntype: 'textbox', width: 120 },
          ],
          page: null,  
          totalpages: null, 
          number :null,
          first:null,
          last :null,     
         loading: true
        }
      }
      
      onPaginatedNext = (e) =>{
      JSON.stringify("Page next " + e);
     this.getPassengerData(this.state.number + 1);
      }
      onPaginatedPrev = (e) =>{
          
      this.getPassengerData(this.state.number - 1);
      }
      componentDidMount() {
      this.getPassengerData(0);
    
      }
    
    getPassengerData(page) {
       
        axios('http://localhost:8181/api/filter/name1/DESC/'+page+'/10',{ 
            method: 'GET',
            routes: {
                "cors": false
                },
            crossDomain: true,
            headers: {
              'Access-Control-Allow-Origin': '*',
              'Content-Type': 'application/json',
              
            },
          
          }).then(response => {
            var data = response.data.content;
            console.log(response.data);
            this.setState({ 
                passengerList: data,loading: false,
                totalpages : response.data.totalPages,
             first:response.data.first, last:response.data.last,number:response.data.number}, () => {
            });
           })
      }
    render() {
       if (this.state.loading === false)
     {

      let data = this.state.passengerList;
      let source =
      {
          localdata: data,
          datatype: "json",
          datafields:
              [
                  { name: 'name1', type: 'string' },
                  { name: 'name2', type: 'string' },
              ]
      };

     var dataAdapter = null;
     dataAdapter = new jqx.dataAdapter(source);
     console.log("Data adapter Render" +JSON.stringify( dataAdapter));
    
      return (
         <div>
          
          <div id="jqxgrid">

            <JqxGrid  ref='Grid' width={850} source={dataAdapter} columns={this.state.columns}
             enabletooltips={true} selectionmode={'multiplecellsadvanced'} />
           </div>
           <button className="btn" text ="Previous" onClick={this.onPaginatedPrev}>Previous</button>
           <button className="btn" text ="Next" onClick={this.onPaginatedNext}>Next</button>
           
           </div>
          )
     } else
     return (
         <div>
             Loading...
         </div>
     )

  
    }

    
}

export default Passenger;