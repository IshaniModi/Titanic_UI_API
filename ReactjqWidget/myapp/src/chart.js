import React from 'react';
import axios from 'axios';
import HighchartsReact from 'highcharts-react-official'
import Highcharts from 'highcharts'


export default class Chart extends React.Component {
  
  constructor(props) {
    super(props)
    this.handleRefresh =  this.handleRefresh.bind(this);

    this.state = {
        Chartdata : [],
        loading : false
    }
  }
  handleRefresh()  {
    this.forceUpdate();
  }
  componentDidMount() {
  this.getChartData();
  }
 
  getChartData() {
      
     axios('http://localhost:8181/api/count/Sex/Sex/ASC',{
        method: 'GET',
        crossDomain: true,
      }).then(response => {
        var newArray = new Array();
        for (var key in response.data) {
        if ( response.data.hasOwnProperty(key)) {
            newArray.push([key, response.data[key]]);
        }
      } this.setState({ Chartdata : newArray, loading :true }, () => {}); 
    })
  };

  render() {
    if (this.state.loading === true)
    {
        const chartOptions = {
            title: {
              text: ""
            },
            series: [{
                data:this.state.Chartdata,// [[ "female",100], ["male",150]],
                keys: ["name", "y"],
                type: "pie"
                        }]
          };
        const Chart = ({ options, highcharts }) => (
            <HighchartsReact
              highcharts={highcharts}
              constructorType={"chart"}
              options={options}
            />
          );
     return(<div>
        <Chart options={chartOptions} highcharts={Highcharts} />
      </div>
    )
    }
    else{ 
      return (
          <div>
              <p>Loading</p>
          </div>
      )
    }

  
      
}

}