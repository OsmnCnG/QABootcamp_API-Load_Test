from locust import HttpUser, between, task


class WebsiteUser(HttpUser):
    wait_time = between(5, 15)

    @task
    def update_pet(self):
        update_data = {
            "id": 1236540038,
            "category": {
                "id": 1818,
                "name": "Dog"
            },
            "name": "bubu",
            "photoUrls": [
                "string"
            ],
            "tags": [
                {
                    "id": 0,
                    "name": "string"
                }
            ],
            "status": "available"
        }
        self.client.put("/v2/pet",json=update_data)

    @task
    def create_pet(self):
        create_data = {
          "id": 1236540038,
          "category": {
            "id": 0,
            "name": "string"
          },
          "name": "bubu",
          "photoUrls": [
            "string"
          ],
          "tags": [
            {
              "id": 0,
              "name": "string"
            }
          ],
          "status": "available"
        }
        self.client.post("/v2/pet",json=create_data)

    @task
    def get_pet_information(self):
        self.client.get("/v2/pet/1236540038")

    @task
    def delete_pet(self):
        self.client.delete("/v2/pet/1236540038")