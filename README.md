# springboot-gcp-pubsub
Google Pub/Sub example with spring boot 

This is an example of how to use google pub/sub with spring boot. This example assumes you are already familiar with google cloud console, goolgle pub/ub and spring boot.

There are two applications in this repository:
 * receiver (push data from subscription)
 * sender (publish data in a topic)

# Setup the applications

 Generate a key file from a service account of your google cloud console and replace it on the files:
 
 * /receiver/src/main/resources/application.yaml
 * /sender/src/main/resources/application.yaml

You must change:
* <YOUR_PROJECT_ID>
* <YOUR_ENCODED_KEY>

# Publishing data in a topic 

There are two topics in this example one handles pure string and the other handles POJO object:

### Publishing pure string

curl --location --request POST 'http://localhost:8081/sendMessage?message=hello' \
--header 'Content-Type: application/json' \
--data-raw '{
    "phoneNumber": "5518997896607",
    "encodeFile": "sdasdasdadadasa"
}'

### Publishing POJO object

curl --location --request POST 'http://localhost:8081/sendPojo' \
--header 'Content-Type: application/json' \
--data-raw '{
    "phoneNumber": "5518997896607",
    "encodeFile": "erwerwerdfsd5sfsd878978979879rere"
}'




