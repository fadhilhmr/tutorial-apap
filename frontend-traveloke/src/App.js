import logo from './logo.svg';
import './App.css';
import React, { Component } from "react";
import Layout from "./components/Layout";
import HotelList from "./containers/HotelList";



class App extends Component {
  render() {
  return (
   <Layout>
     <HotelList />
    </Layout>
   );
  }
}  

export default App;
