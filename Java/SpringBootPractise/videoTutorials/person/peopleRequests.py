"""
Author: Thanos Moschou
Description: This is a simple python script that sends request to my person api. It is built to test the api.
"""

import requests

url = "http://localhost:8080/person"

print("*****READ ALL PEOPLE FROM THE DATABASE*****")
readAllPeopleResponse = requests.get(url)
print(readAllPeopleResponse.text)

print("*****READ PERSON BY ID*****")
readPersonByIdResponse = requests.get(url + "/p1")
print(readPersonByIdResponse.text)

print("*****UPDATE PERSON BY ID*****")
updatedPerson = {"id" : "p1", "name" : "Thanos", "age" : 25} #this object has the same id as before, the same name as before and the only thing that is different is the age (it was 20)
requests.put(url + "/" + updatedPerson["id"], json = updatedPerson)

readPersonByIdResponse = requests.get(url + "/p1") #check if user is updated by making a get request passing his id
print(readPersonByIdResponse.text)

print("*****CREATE PERSON*****")
createdPerson = {"id" : "p5", "name" : "Maria", "age" : 28}
requests.post(url, json = createdPerson)

readPersonByIdResponse = requests.get(url + "/" + createdPerson["id"]) #check if user is created by making a get request passing his id
print(readPersonByIdResponse.text)

print("*****READ ALL PEOPLE FROM THE DATABASE*****")
readAllPeopleResponse = requests.get(url)
print(readAllPeopleResponse.text)

print("*****DELETE PERSON BY ID*****")
requests.delete(url + "/" + "p5")

print("*****READ ALL PEOPLE FROM THE DATABASE*****")
readAllPeopleResponse = requests.get(url)
print(readAllPeopleResponse.text)