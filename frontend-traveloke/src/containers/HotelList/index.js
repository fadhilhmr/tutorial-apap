import React, { Component } from "react";
import Hotel from "../../components/Hotel";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
import APIConfig from "../../api/APIConfig";
import classes from "./styles.module.css";


class HotelList extends Component {
constructor(props) {
    super(props);
    this.state = {
        hotels: [],
        isLoading: false,
        isCreate: false,
        isEdit: false,
        namaHotel: "",
        alamat: "",
        nomorTelepon: "",
        tempHotel:[],
        filterKey:"",    
    };
    this.handleAddHotel = this.handleAddHotel.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this);
    this.handleEditHotel = this.handleEditHotel.bind(this);
    this.handleSubmitEditHotel = this.handleSubmitEditHotel.bind(this);
    this.handleDeleteHotel = this.handleDeleteHotel.bind(this);
    this.handleFilter = this.handleFilter.bind(this);
    // this.handleClickLoading = this.handleClickLoading.bind(this);
}

async handleSubmitAddHotel(event) {
    event.preventDefault();
    try {
        const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
        };
        await APIConfig.post("/hotel", data);
        this.loadData();
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditHotel(event) {
        event.preventDefault();
        try {
        const data = {
        namaHotel: this.state.namaHotel,
        alamat: this.state.alamat,
        nomorTelepon: this.state.nomorTelepon,
        };
        await APIConfig.put(`/hotel/${this.state.id}`, data);
        this.loadData();
        } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
        this.handleCancel(event);
    }
    async handleDeleteHotel(id) {
        try {
        await APIConfig.delete(`/hotel/${id}`);
        this.loadData();
        } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
    }

handleAddHotel() {
    this.setState({ isCreate: true });
}
handleCancel(event) {
    event.preventDefault();
    this.setState({ isCreate: false, isEdit: false,namaHotel: "",alamat: "",
    nomorTelepon: ""});
}
handleEditHotel(hotel) {
    this.setState({
    isEdit: true,
    id: hotel.id,
    namaHotel: hotel.namaHotel,
    alamat: hotel.alamat,
    nomorTelepon: hotel.nomorTelepon,
    });
 }
    
componentDidMount() {
    this.loadData();
}

async loadData() {
    try {
        const { data } = await APIConfig.get("/hotels");
        this.setState({ hotels: data, tempHotel: data});
    }
    catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
}

handleChangeField(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
    }

handleFilter(event) {
    let hotels = this.state.hotels;
    let tempHotel = this.state.tempHotel;
    let addedHotel = [];
    let filterKey = event.target.value;
    for(let i = 0;i<hotels.length;i++){
        if (hotels[i].namaHotel.includes(filterKey)){
            addedHotel.push(hotels[i]);
        }
    }
    this.setState({tempHotel:addedHotel})
}
    

    
// shouldComponentUpdate(nextProps, nextState) {
//     console.log("shouldComponentUpdate()");
// }

// handleClickLoading() {
//     const currentLoading = this.state.isLoading;
//     this.setState({ isLoading: !currentLoading });
//     console.log(this.state.isLoading);
// }
    

render() {
    console.log("render()");
    return (
        <div className={classes.hotelList}>
            <h1 className={classes.title}>All Hotels</h1>
            <Button onClick={this.handleAddHotel} variant="primary">
            Add Hotel
            </Button>
            <input
                    type="text"
                    placeholder="Search a Hotel"
                    name="filterKey"
                    // value={this.state.filterKey}
                    onChange={this.handleFilter}
                />
            <div>
                {this.state.tempHotel.map((hotel) => (
                <Hotel
                key={hotel.id}
                id={hotel.id}
                namaHotel={hotel.namaHotel}
                alamat={hotel.alamat}
                nomorTelepon={hotel.nomorTelepon}
                listKamar = {hotel.listKamar}
                handleEdit={() => this.handleEditHotel(hotel)}
                handleDelete={() => this.handleDeleteHotel(hotel.id)}
                />
                ))}
            </div>
            <Modal show={this.state.isCreate || this.state.isEdit} handleCloseModal={this.handleCancel}>
                <form>
                    <h3 className={classes.modalTitle}>
                    {this.state.isCreate
                    ? "Add Hotel"
                    : `Edit Hotel Nomor ${this.state.id}`}
                    </h3>
                    <input
                    className={classes.textField}
                    type="text"
                    placeholder="Nama Hotel"
                    name="namaHotel"
                    value={this.state.namaHotel}
                    onChange={this.handleChangeField}
                />
                <input
                    className={classes.textField}
                    type="text"
                    placeholder="Alamat"
                    name="alamat"
                    value={this.state.alamat}
                    onChange={this.handleChangeField}
                />
                <textarea
                    className={classes.textField}
                    placeholder="Nomor Telepon"
                    name="nomorTelepon"
                    rows="4"
                    value={this.state.nomorTelepon}
                    onChange={this.handleChangeField}                    
                />
                <Button
                onClick={
                    this.state.isCreate
                    ? this.handleSubmitAddHotel
                    : this.handleSubmitEditHotel
                }
                variant="primary"
                >
                    {this.state.isCreate ? "Create" : "Edit"}
                </Button>
                <Button onClick={this.handleCancel} variant="danger">
                    Cancel
                </Button>
            </form>
        </Modal>
    </div>
);
}
}
export default HotelList;
