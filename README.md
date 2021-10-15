# BarCodeScanner
This repository contains an **Android Application developed in Kotlin** that integrates the ***ZXING library*** (Consulted at the following LINK: https://github.com/zxing/zxing).

The application has the ability to read different barcode standards, among which we find:

| 1D product | 1D industrial | 2D |
| :---: | :---: | :---: |
| UPC-A |	Code 39	| QR Code | 
| UPC-E |	Code 93 |	Data Matrix |
| EAN-8 |	Code 128 | Aztec |
| EAN-13 | Codabar | PDF 417 |
| UPC/EAN Extension 2/5 | ITF |	MaxiCode |
| | | RSS-14 |
| | | RSS-Expanded |

The app contains a simple button that calls the camera to request permissions for use and then after scan the data is indicated in a Toast.
