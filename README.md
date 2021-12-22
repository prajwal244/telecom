# telecom

#1. Create customer: http://localhost:8080/v1/customer

Body

{
    "name":"Ramprasad",
    "email":"ram@gmail.com",
    "date":"1999-02-12"
}

Responce

{
    "id": 1,
    "name": "Ramprasad",
    "email": "ram@gmail.com",
    "date": "1999-02-12"
}

2. Create Sim: http://localhost:8080/v1/sim

Body

{
    "simNumber":"55882237766",
    "simPin":"55555"
}

Responce

{
    "id": 2,
    "simNumber": "55882237766",
    "simPin": "55555"
}

3. Get Customer by id : http://localhost:8080/v1/customer/1

Body:none

Responce

{
    "id": 1,
    "name": "Ramprasad",
    "email": "ram@gmail.com",
    "date": "1999-02-11",
    "sim": []
}

4. Link Sim to Customer: http://localhost:8080/v1/link/1

Body

{
    "id":[5] # sim id
}

Responce

{
    "id": 1,
    "name": "Ramprasad",
    "email": "Loop@gmail.com",
    "date": "1999-12-29",
    "sim": [
        {
            "id": 2,
            "simNumber": "55882237766",
            "simPin": "55555"
        }
    ]
}

5. Get all customer: http://localhost:8080/v1/customer

Body:none

Responce

[
    {
        "id": 1,
        "name": "Ramprasad",
        "email": "ram@gmail.com",
        "date": "1999-02-11",
        "sim": []
    },
    {
        "id": 2,
        "name": "Loop",
        "email": "Loop@gmail.com",
        "date": "1999-02-10",
        "sim": []
    },
    {
        "id": 6,
        "name": "Loop",
        "email": "Loop@gmail.com",
        "date": "1999-02-18",
        "sim": [
            {
                "id": 5,
                "simNumber": "55882237766",
                "simPin": "55555"
            }
        ]
    }
]

6. Get Sim By Customer Id: http://localhost:8080/v1/sim/1

Body:none

Responce

{
    "id": 2,
    "simNumber": "55882237766",
    "simPin": "55555"
}

7. Get all Sim: http://localhost:8080/v1/sim

Body:none

Responce

[
    {
        "id": 3,
        "simNumber": "55882237766",
        "simPin": "55555"
    },
    {
        "id": 4,
        "simNumber": "55882237766",
        "simPin": "55555"
    },
    {
        "id": 5,
        "simNumber": "55882237766",
        "simPin": "55555"
    }
]
