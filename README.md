# Tutorial APAP
## Authors
* **FADHIL ILHAM RAHMADI** - *1806191194* - *A*

### What I have learned today TUTORIAL 7
### Pertanyaan

1. *Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi
dari apa yang Anda jelaskan.*

- Pembuatan Component (Item dan List)
Pertama, setelah menginisiasi react app, maka hal yang pertama dalajh membuat component. disini componenet dibagi menjadi dua, yaitu item dan list dimana kedua component ini akan digunakan di main app.js (seperti penggunaan fragment di html atau class di OOP Java).

- Class-Based Implementation
Class-Based Implementation merupakan penggunaan components di dalam app.js atau main file jsnya, dimana penggunaan yang dipakai seperti memanggil class di oop, dimana harus diinisasi dan dapat digunakan isinya di dalam function JSnya.

- State
Disini kami belajar menggunakan state, suatu variabel yang bertindak sebagai syarat kondisi dalam suatu objek yang diisi dengan kontanta lain lainnya. Hal ini dapat membantu ketika ingin menjalankan sesuatu dengan kondisi dari suatu variabel tertentu. State juga membantu untuk mengidentifikasi kondisi dari suatu variabel yang akan dijadikan parameter di fungsi tertentu.

- event handler function
Dalam main appnya, untuk menampilkan tampilan di pagenya, maka menggunakan funtion yang berisi tag html yang akan ditampilkan. Untuk beberapa kasus, ada event hadler function, yang merupakan logis dari suatu algoritma untuk menampilkan hal hal tertentu, sesuai dengan isinya dan didasar denagn event yang memicunya
https://docs.google.com/document/d/17steajzQVcp7ISuUB1APz1QK1rQ2kszRfFqXnScXDlA/edit?usp=sharing

2. *Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?*
Dalam js file, penggunaan state bisa disebut sebagai kondisi yang tercakupi dari suatu function, dimana dapat berbentuk konstanta sebagai variabelnya. Contohnya adalah state dari suatu function dapat dilihat dari nilai boolean dari konstanta showFavorite. Sehingga untuk if else condition dalam suatu tag, dapat menggunakan state dari objek tersebut. Sedang props jika dianalogikan seperti argumen atau constructor dari suatu js file.

3. *Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!*
Keuntungan dari component merupakan pengimplemntasian microservice di React, sehingga component dapat memmfokuskan pembngunan lebih ke fitut yang memiliki depedensinya masing masing.
4. *Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?*
Pembangunan web yang meenggunakan react dapat menawarkan fitur fitur yang memiliki daya interaksi yang lebih terhadap pengguna. JS dalam React juga memungkinkan 8 golden rules yang baik terhadap fungisionalitas dan juga estitetika dari webnya. Pemubuatan juga bersifat dinamis dan pengimpelemntasian yang baik juga memastikan efektivitas dan efiesiensi dalam pembuatan
5. *Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?*
Dari pengalaman saya, dokumentasi dari react sangatlah berantakan, dimana saya sendiri kesusahan untuk menemukan flow dari codingan tutorial ini.

### What I have learned today TUTORIAL 6
### Pertanyaan
1. *Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda
buat) konsep tersebut diimplementasi?*
Otentikasi adalah proses menverifikasi sebuah akun sekaligus memvalidasi sebuah akun. Di tutorial ini, otentikasi dilakukan saat melakukan login dengan menghubungkan ke DB. Otorisasi adalah tahapan setelahh otentikasi, dimana otorisasi adalah penentuan peran dan otoritas dari suatu peran di sistem, otorisasi dilaksanakan saat antMatchers ataupun sec:authorize yang menerukan jenis role yang bisa menggunakan app.
2. *Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.*
BCryptPasswordEncoder merupakan suatu objek pengolah password yang mengencrypt passowrd dengan menghashnya. Cara kerjanya adalah dengan menerima string password, maka akan dihash dan juga ditambahkan random char untuk mengecohh dan meningkatkan keamanan.
3. *Jelaskan secara singkat apa itu UUID beserta penggunaannya!*
UUID (Universally Unique IDentifiers) adalah suatu identifier yang melabelkan suatu data agar data tersebut unik dan berbeda. UUID di database dapat berperan sebagai Key Attribute
4. *Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah
memiliki class UserRoleServiceImpl.java?*
UserDetailsServiceImpl merupakan implementasi dari interface UserDetailsService dengan tujuan untuk mengambil data user yang sudah di otentikasi yang disediakan dari sistemnya. Sedangkan UserServiceImpl merupakan implementasi dari interface User service yang merupakan buatan dari developer sendiri.


### What I have learned today TUTORIAL 5
### Pertanyaan
1. *Apa itu Postman? Apa kegunaannya?*
Postman merupakan client API yang berguna untuk membantu dalam membuat dan menguji API yang digunakan. Postman berjalan dengan mendokumentasikan request yang diberikan dan mengujinya dengan response dari sistem yang sudah diimplementasi REST juga
2. *Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty*
JsonIgnoreProperties adalah property suatu class untuk menujukkan Properties yang tidak akan dimasukkan dalam pemetaan data yang diolah, sepertinpada soal ini dimana Hotel di ignore dalam proses crud kamar dinturorial ini
JsonProperty berguna untuk menandakan sesuatu attribut/field di java sebagai Json Propert yang dapat digunakan data mapper milik Json
3. *Apa kegunaan atribut WebClient?*
WebClient adalah modul dari Spring dalam mengolah suatu HTTP reauests. Webclient dapat mengolah dan mengambil request dan juga response dari suatu URL yang dituju untuk mengakses value value tertentu
4. *Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?*
responseEntity meruapkan suatu respon HTTP terhadap suatu request yang berisi status, header dan juga isi. ResponseEntity dapat menngirim respon pesan atas request tersebut. sedangkan Binding Result adalah objek spring yang mengambil error dan ememvalidasi suatu objek yang ingin divalidasi.


### What I have learned today TUTORIAL 4
### Personal Note
1. *Jelaskan perbedaan th:include dan th:replace!*
Perbedaannya adalah include akan menambahkan fragment ke div yang ditentukan, sedangkan replace akan mengganti tag div terpilih dengan isi fragment.
2. *Jelaskan apa fungsi dari th:object!*
fungsi th:object adalah untuk mengikat tag html dengan objek yang tersedia, sehingga di dalam tag tersebut bisa memanggil attributnya secara lansgung dengan asterisk "*{attr}" , dimana tanpa th:object bantuknya akan seperti ini = "${object.attr}"
3. *Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?*
 sebenarnya kegunaan dari * dan $ di th:object, sama sama untuk mngakses object. perbadaanya adalah $ digunakan ketika object belum diinisiasi sebelumnya katika diakses, sedangkan * menambahkan attribut dari object yang sudah diinisiasi oleh tag tertentu seperti th:object
4. *Bagaimana kamu menyelesaikan latihan nomor 3?*
Untuk latihan tiga, saya memanfaatkan fragment yang sudah ada dengan menambahkan argumen dengan input string, sehingga setiap dimasukkan string di argumen fragment tersebut, maka fragment akan mengupdate isi navbarnya dengan string yang didapatkan dari masing masing html.


### What I have learned today TUTORIAL 3
### Personal Note
1. *Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?*
Method tersebut berguna untuk mengakses database dan mereturn semua isi database dengan hotel ID yang ditaruh di argumen.
2. *Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?*
perbedannya adalah bahwa addhotelformpage mengambil data yang sudah ada dan dimasukkan ke model untuk direturn ke file html, sedangkan addhotelsubmit aka mengembalikan updated model yang berisid ari input user ke html yang sama.
3. *Jelaskan kegunaan dari JPA Repository!*
JPA repository merupakan database yang memerakan java class kita ke relational table. JPA repository membuat convert dari jaca ke database menjadi lebih mudah
4. *Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?*
ketika ada tambahan anotasi dimasing masing Model yaitu onetomany/manytoone, dimana membuat kedua database saling mereferensikan satu sama lain
5. *Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER*
fetchtype.lazy =  untuk membuat seluruh object , KETIKA dipanggil  
cascadetype.all = untuk mendukung perubahasn CRUD database
fetchtype.eager = dibuat untuk relasi one to one dan many to one lalu bisa digunakan langsung untuk memanggil object

### What I have learned today TUTORIAL 2
### Personal Note
1. *Pertanyaan 1*
Karena belum disediakan html file/template untuk ditampilkan ke pengguna di website.
2. *Pertanyyaan 2*
Menurut saya, Autowired bertugas untuk secarar otomatis membuat semua class/fungsinya mengimplement suatu package/class tertentu, sehingga ada gungsi atau class yang dibuat dapat diberikan depedensinya.

3. *Pertanyaan 3*
Hal ini karena inisiasi dari hoteModel yang sudah dibuat mengharuskan  adanya input nomor telepon yang bersifat sebagai string. Ketidakadaan data membuat null dan raise error untuk pembuatan data tersebut. Harus dibuat handler untuk kases itu.
4. *Pertanyaan 4*
untuk mencari sesuai nama, maka dibutuhkan handler baru yang dapt menginterasi ke isi list hotel dan mencocokkan string nama input dengan nama hotel yang sudah ada.
5. *Pertanyaan 5*
link ini akan menampilkan seluruh data hotel yang sudah dibuat. screenshot berada di link ini
https://docs.google.com/document/d/1uWwF0eOFpuvFy5MT5_DZJENgk9PAIR8QgpaXR_uLcVs/edit?usp=sharing


### What I have learned today TUTORIAL 1
### Personal Note
### Github
1. *Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?*
Menurut saya, issue tracker adalah suatu fitur untuk mengawasi atau memulai suatu pengerjaan solusi dari suatu branch atau feature yang sudah dibuat
2. *Apa perbedaan dari git merge dan git merge --squash?*
git merge akan menyimpan semua versionn dari commit yang ada di branch tersebut. Dengan --squash, maka hanya akan ada satu commit daja dari brannch tersebut yang akan dipush ke master.
3. *Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?*
kelebihan dari penggunaan GIT adalah kita bisa mengontrol apa yang kita kerjakan melalui log yang ada dan juga ada safety condition ketka kita ingin mengubah sesuatu bisa melalui branch untuk meminimalisir perubahan data master/utama. dengan adanya versionn control system, kita bisa mentrack semua perubahan yang pernah terjadi dengan code kita.
### Spring
4. *Apa itu library & dependency?*
**Library** adalah kumpulan objek/class yang sudah digabungkan  dan siap di impelementasikan. **depedency** adalah hal yang membuat objjek tersebut bergantung dengan kelas lain.
5. *Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?*
Setahu saya, maaven adalah seperti package yang memiliki format dan aturan sendiri, sehingga, ketika kit amengejakan sesuatu secara kolaborartif, ada acuan yang bisa digunakan bersama. Alternatif dari Maven adalah gradle.
6. *Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?*
pengembangan suatu sistem informasi, mobile app
7. *Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?*
@RequestParam mendapatkan value dari query ayng ada di app tersebut, sedangkan @PathVaariable mendapatkan nilai dari URI-nya. Kegunaan requestparam lebih ke web sederhana/trqadisional, sedangkkan pathvariable untuk web yang kompleks.
### What I did not understand
- [x] apa saja command line penting ketika menggunakan command prompt
- [ ] memperdalam REST dan penggunaan API
- [x] Adaptasi menggunakan Intelij
- [ ] Konsep abstract dan interface di java harus dikaji ulang
 - [ ] method dan object di JPA dan perdatabasean java

