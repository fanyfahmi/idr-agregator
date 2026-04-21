# IDR-Agregator
Ikuti langkah-langkah di bawah ini untuk menjalankan project **IDR Agregator** di perangkat lokal Anda.

## SETUP/RUN INSTRUCTION :

1. Clone Repository
```
git clone https://github.com/fanyfahmi/idr-aggregator.git
cd IDR-Finance-Rate-Aggregator
pull origin main 
```
2. Build Aplikasi
```
./mvnw clean install
```
3. Start unit test
```
./mvnw test
```
4. start aplikasi 
```
./mvnw spring-boot:run
```
aplikasi berjalan di http://localhost:8080

## ENDPOINT USAGE :

1. Latest Rates IDR 
```
http://localhost:8080/api/finance/data/latest_idr_rates
```
2. Historical IDR to USD 
```
http://localhost:8080/api/finance/data/supported_currencies
```
3. Supported Currencies
```
http://localhost:8080/api/finance/data/supported_currencies
```
## PERSONALIZATION NOTE :

GitHub Username: fanyfahmi

Spread Factor: 0.00947

(Dihitung berdasarkan: Jumlah ASCII "fanyfahmi" (947) % 1000 / 100000.0)
