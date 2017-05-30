#!/bin/bash
printf "\n\n-------Using curl to hit API-------\n\n"

#printf "\nPost  /TodoLambda, value = 1\n"
curl -X POST \
  https://6kposkbylg.execute-api.us-east-1.amazonaws.com/prod/getAnswer \
  -H 'cache-control: no-cache' \
  -H 'postman-token: d539dd47-d3fb-bf14-ed43-efdb592a095c' \
  -H 'x-api-key: dq6dJwgKXg2jha3Uk56Fo1BqYDAOOOiK7BjuU5Xb' \
  -d '{
  "actions": [
    {
      "name": "recommend",
      "value": "1",
      "type": "button"
    }
  ],
  "callback_id": "comic_1234_xyz",
  "team": {
    "id": "T47563693",
    "domain": "watermelonsugar"
  },
  "channel": {
    "id": "C065W1189",
    "name": "forgotten-works"
  },
  "user": {
    "id": "U045VRZFT",
    "name": "brautigan"
  },
  "action_ts": "1458170917.164398",
  "message_ts": "1458170866.000004",
  "attachment_id": "1",
  "token": "xAB3yVzGS4BQ3O9FACTa8Ho4",
  "original_message": {"text":"New comic book alert!","attachments":[{"title":"The Further Adventures of Slackbot","fields":[{"title":"Volume","value":"1","short":true},{"title":"Issue","value":"3","short":true}],"author_name":"Stanford S. Strickland","author_icon":"https://api.slack.comhttps://a.slack-edge.com/bfaba/img/api/homepage_custom_integrations-2x.png","image_url":"http://i.imgur.com/OJkaVOI.jpg?1"},{"title":"Synopsis","text":"After @episod pushed exciting changes to a devious new branch back in Issue 1, Slackbot notifies @don about an unexpected deploy..."},{"fallback":"Would you recommend it to customers?","title":"Would you recommend it to customers?","callback_id":"comic_1234_xyz","color":"#3AA3E3","attachment_type":"default","actions":[{"name":"recommend","text":"Recommend","type":"button","value":"recommend"},{"name":"no","text":"No","type":"button","value":"bad"}]}]},
  "response_url": "https://hooks.slack.com/actions/T47563693/6204672533/x7ZLaiVMoECAW50Gw1ZYAXEM"
}'

printf "\n\n-----------------------------------\n\n"
