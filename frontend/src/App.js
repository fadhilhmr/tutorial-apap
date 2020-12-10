import React from "react";

import List from "components/List";
import listMovies from "movies.json";
import "./App.css";

export default class App extends React.Component {
    state = {
        favItems: [],
        delButton : true,
        favContent:false,
        showed:false,
    }

    handleItemClick = (item) => {
        const newItems = [...this.state.favItems];
        const newItem = {...item};

        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
    
        if (targetInd < 0) newItems.push(newItem);
        // else newItems.splice(targetInd, 1);

        this.setState({favItems: newItems, delButton: false, favContent: true});

    }

    handleItemClickRight = (item) => {
        const newItems = [...this.state.favItems];
        const newItem = {...item};

        const targetInd = newItems.findIndex((it) => it.id === newItem.id);

        if (targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd, 1);
        this.setState({favItems: newItems});
        if (newItems.length == 0) this.setState({delButton:true, favContent:false});

    }

    enableDelete = (item) => {
        this.setState({favItems:[], delButton: true, favContent:false});
    }

    showFav = (item) => {
        var checkbox = document.querySelector('input[type="checkbox"]');
        if (checkbox.checked){
            this.setState({showed:true})
        }
        else{
            this.setState({showed:false})
        }

    }

    render() {
        const { favItems } = this.state;

        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
                <p className="text-center text-secondary text-sm font-italic">(This is a <strong>class-based</strong> application)</p>
                <div className="text-center">
                    <button className="btn btn-danger" onClick={this.enableDelete} hidden={this.state.delButton}>Hapus</button>
                </div>

                <label className="switch">
                    <input onClick={this.showFav} type="checkbox"/>
                        <div className="slider"></div>
                </label>

                <div className="container pt-3">
                    <div className="row">
                        <div className="col-sm">
                            <List title="List Movies" items={listMovies} onItemClick={this.handleItemClick}></List>
                        </div>
                        <div hidden={this.state.showed} className="col-sm">
                            <List title="My Favorites" items={favItems} onItemClick={this.handleItemClickRight}></List>
                            <div hidden={this.state.favContent}>
                                <h3>Film Favorite Masih Kosong</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}