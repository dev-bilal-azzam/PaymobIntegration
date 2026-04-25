# 💳 Paymob Android SDK Integration

This project demonstrates how to integrate the Mobile SDK from :contentReference[oaicite:0]{index=0} into an Android application to support:

- Online card payments  
- Mobile wallet payments  

It provides a clean and simple implementation using Kotlin, MVVM architecture, and modern Android tools.

---

## 📖 Read Full Article

For a complete step-by-step explanation of the implementation, architecture decisions, and production considerations, read the full article:

👉 [Paymob Mobile SDK Integration with Android (Full Guide)](https://bilal-azzam.medium.com/paymob-mobile-sdk-integration-with-android-pay-with-e-wallets-online-cards-bbeb7ff041b4?postPublishedType=repub)

### The article covers:
- Full integration walkthrough  
- Payment intention details  
- SDK usage in Android  
- Common mistakes  
- Production-ready improvements  

---

## ⚠️ Important Notes

This project is intended for **educational purposes only**.

### For production applications:
- Move Secret Key to backend server  
- Use webhooks for payment verification  
- Do not rely on SDK callbacks as final payment status  
- Treat SDK as UI layer only  

---

## 🔑 Required Credentials

From Paymob dashboard you need:

- Public Key → used in SDK  
- Secret Key → used to create payment intention  
- Integration IDs → for different payment methods  

⚠️ **Important:**  
Secret Key must never be exposed in production mobile apps.

---

## 💳 Payment Flow

1. User enters payment amount  
2. App sends request to create Payment Intention  
3. Paymob returns `client_secret`  
4. SDK is launched using:
   - Public Key  
   - Client Secret  
5. User completes payment (card or wallet)  
6. Result is returned via SDK callbacks  

---

## Demo :
[![Using Mobile Wallets](https://img.youtube.com/vi/mBhDEXB6DWo/0.jpg)](https://www.youtube.com/shorts/mBhDEXB6DWo)

[![Using Mobile Wallets](https://img.youtube.com/vi/Q3zOKYvKuOE/0.jpg)](https://www.youtube.com/shorts/Q3zOKYvKuOE)
