import json

def lambda_handler(event, context):
    recodrds = event['Records']
    payload = recodrds['body']
    print(payload)