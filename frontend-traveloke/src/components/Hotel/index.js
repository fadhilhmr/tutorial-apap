import React from "react";
import classes from "./styles.module.css";

const Hotel = (props) => {
const { id, namaHotel, alamat, nomorTelepon, listKamar} = props;


return (
<div className={classes.hotel}>
 <h3>{`ID Hotel ${id}`}</h3>
 <p>{`Nama Hotel: ${namaHotel}`}</p>
 <p>{`Alamat: ${alamat}`}</p>
 <p>{`Nomor telepon: ${nomorTelepon}`}</p>
 <div>
 {listKamar.map((kamar) => (
                <Kamar
                nama={kamar.namaKamar}
                jumlah={kamar.jumlah}
                />
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
