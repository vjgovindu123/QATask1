import requests

BASE_URL = "https://reqres.in/api"
headers = {
    "x-api-key": "reqres-free-v1",
    "User-Agent": "Mozilla/5.0"
}

def test_successful_response():
    response = requests.get(f"{BASE_URL}/users?page=2", headers=headers)
    assert response.status_code == 200

def test_response_content():
    response = requests.get(f"{BASE_URL}/users/2", headers=headers)
    assert response.status_code == 200
    data = response.json()
    assert data["data"]["id"] == 2

def test_error_handling_not_found():
    response = requests.get(f"{BASE_URL}/users/23", headers=headers)
    assert response.status_code == 404

def test_post_create_user():
    payload = {"name": "vijay", "job": "QAAnalyst"}
    response = requests.post(f"{BASE_URL}/users", json=payload, headers=headers)
    assert response.status_code == 201
