To run the project, it should have RSA private and public keys inside the resource/cert directory.

### To generate own key: 

1. create rsa key pair : openssl genrsa -out keypair.pem 2048
2. extract public key : openssl rsa -in keypair.pem -pubout -out public.pem
3. create private key in PKCS#8 format: openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem

