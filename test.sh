#!/bin/bash

echo "Creating Account 1..."
curl -s -X POST http://localhost:8080/api/accounts \
  -H "Content-Type: application/json" \
  -d '{"owner":"JeanP","balance":1000.00}'
echo -e "\n"

echo "Creating Account 2..."
curl -s -X POST http://localhost:8080/api/accounts \
  -H "Content-Type: application/json" \
  -d '{"owner":"Michael","balance":500.00}'
echo -e "\n"

echo "Listing all accounts..."
curl -s http://localhost:8080/api/accounts
echo -e "\n"

echo "Transferring money"
curl -s -X POST http://localhost:8080/api/transfers \
  -H "Content-Type: application/json" \
  -d '{"from":1,"to":2,"amount":200.00}'

echo "Listing accounts after transfer..."
curl -s http://localhost:8080/api/accounts
echo -e "\n"

echo "Script complete"
