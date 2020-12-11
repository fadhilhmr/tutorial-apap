import React from "react";
import classes from "./styles.module.css";
import Button from "./../Button";

const Hotel = (props) => {
const { id, namaHotel, alamat, nomorTelepon, handleEdit, handleDelete,listKamar} = props;


return (
<div className={classes.hotel}>
 <h3>{`ID Hotel ${id}`}</h3>
 <p>{`Nama Hotel: ${namaHotel}`}</p>
 <p>{`Alamat: ${alamat}`}</p>
 <p>{`Nomor telepon: ${nomorTelepon}`}</p>
 <div>
 {listKamar.map((kamar) => (
     <div>
                <h6>{kamar.namaKamar}</h6>
                <h6>{kamar.jumlah}</h6>
     </div>
                ))}

 </div>
 
 <Button onClick={handleEdit} variant="success">
Edit
</Button>
<Button onClick={handleDelete} variant="danger">
Delete
</Button>


 </div>
);
};

export default Hotel;
