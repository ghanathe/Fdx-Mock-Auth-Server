
# FDX Authorization Server

#### Mastercard Developer Hub documentation: https://developer.mastercard.com/fdx-dev-hub/documentation

## Description
Introducing our cutting-edge authentication server solution, meticulously designed to empower banks and financial institutions with a robust and secure authentication framework. This server is implemented with a strong focus on OAuth 2.0 and OpenID Connect (OIDC)—both of which are renowned for their security and widespread adoption.
Our solution excels in token issuance, validation, and management, serving as a secure gateway for client applications and ensuring that all transactions are handled with the utmost integrity. Moreover, all API responses are fully compliant with the Financial Data Exchange (FDX) 6.0 standard, guaranteeing interoperability, data integrity, and adherence to industry best practices.

#### FDX Resource Server - https://github.com/Mastercard/Fdx-Mock-Resource-Server

## Prerequisites
1. An IDE that supports Java 17 or above (e.g., Eclipse, IntelliJ IDEA, Spring Tool Suite).
2. Java installed on your local system.
3. [Postman](https://www.postman.com/downloads/) installed on your local system.
4. Docker: [Install Docker](https://www.docker.com/products/docker-desktop/) (Required only for running in docker)

## Installation Instructions
1. Download the project from GitHub.
2. Import the project into your preferred IDE as an existing Maven project.
3. Run the application as a Java Application.
4. Once the project is running, download the Postman collection and environment from the resource/postman folder. 
5. Import the downloaded Postman collection and environment into Postman. 
6. We need to update drJwtSecret in postman environment from project resource folders src/main/resources/dr/drpk.txt
7. We need to add pmlib_code(A crypto utility library for Postman) to global variable, refer this [url](https://joolfe.github.io/postman-util-lib/#installation) to get variable value.
8. You can now use the imported collection to send requests to the API endpoints and observe the responses.

## Usage
**Note:** To run through consent journey and resource APIs skipping DCR, follow below steps with default client id: dh-fdx-client-registrar-2

[<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://god.gw.postman.com/run-collection/36464997-129883a9-586a-47a5-88da-a1d79cc5012d?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D36464997-129883a9-586a-47a5-88da-a1d79cc5012d%26entityType%3Dcollection%26workspaceId%3Dcbf69e43-cf25-4270-87c9-167dacb32122#?env%5BBank%20API%20Nexus%5D=W3sia2V5IjoiaG9zdCIsInZhbHVlIjoibG9jYWxob3N0OjgwODAiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6ImxvY2FsaG9zdDo4MDgwIiwic2Vzc2lvbkluZGV4IjowfSx7ImtleSI6ImRhdGFob2xkZXJEY3JBY2Nlc3NUb2tlbiIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiIiLCJzZXNzaW9uSW5kZXgiOjF9LHsia2V5IjoiY2xpZW50SWQiLCJ2YWx1ZSI6ImRoLWZkeC1jbGllbnQtcmVnaXN0cmFyLTIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6ImRoLWZkeC1jbGllbnQtcmVnaXN0cmFyLTIiLCJzZXNzaW9uSW5kZXgiOjJ9LHsia2V5IjoiY2xpZW50U2VjcmV0IiwidmFsdWUiOiJzZWNyZXQiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6InNlY3JldCIsInNlc3Npb25JbmRleCI6M30seyJrZXkiOiJvYXV0aDJfcmVzcG9uc2VfdHlwZSIsInZhbHVlIjoiY29kZSIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiY29kZSIsInNlc3Npb25JbmRleCI6NH0seyJrZXkiOiJyZWRpcmVjdFVybCIsInZhbHVlIjoiaHR0cHM6Ly9vYXV0aC5wc3Rtbi5pby92MS9icm93c2VyLWNhbGxiYWNrIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiJodHRwczovL29hdXRoLnBzdG1uLmlvL3YxL2Jyb3dzZXItY2FsbGJhY2siLCJzZXNzaW9uSW5kZXgiOjV9LHsia2V5IjoiZHJKd3RTZWNyZXQiLCJ2YWx1ZSI6IkNPUFkgRlJPTSBHSVRIVUIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6IkNPUFkgRlJPTSBHSVRIVUIiLCJzZXNzaW9uSW5kZXgiOjZ9LHsia2V5IjoiZGF0YWhvbGRlcklzc3VlciIsInZhbHVlIjoiaHR0cHM6Ly9mZHgtbW9jay1hdXRob3JpemF0aW9uLXNlcnZlci5kZXYuZmluaS5jaXR5IiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiJodHRwczovL2ZkeC1tb2NrLWF1dGhvcml6YXRpb24tc2VydmVyLmRldi5maW5pLmNpdHkiLCJzZXNzaW9uSW5kZXgiOjd9LHsia2V5IjoiZGF0YWhvbGRlckFjY2Vzc1NoYXJpbmdEdXJhdGlvbiIsInZhbHVlIjoiMzE1MzYwMDAiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6IjMxNTM2MDAwIiwic2Vzc2lvbkluZGV4Ijo4fSx7ImtleSI6ImRhdGFob2xkZXJBY2Nlc3NEdXJhdGlvbiIsInZhbHVlIjoiMzAwIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiIzMDAiLCJzZXNzaW9uSW5kZXgiOjl9LHsia2V5Ijoib2F1dGgyX3Jlc3BvbnNlX21vZGUiLCJ2YWx1ZSI6InF1ZXJ5IiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiJxdWVyeSIsInNlc3Npb25JbmRleCI6MTB9LHsia2V5IjoicGtjZV9jb2RlX2NoYWxsZW5nZSIsInZhbHVlIjoiblpZWi1VT2ZRYzJOc1dWN05ra2xsMTlBTE02bXJjQzdlWFZXVU1QWXBRUSIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiblpZWi1VT2ZRYzJOc1dWN05ra2xsMTlBTE02bXJjQzdlWFZXVU1QWXBRUSIsInNlc3Npb25JbmRleCI6MTF9LHsia2V5IjoiZGF0YWhvbGRlckF1dGhvcmlzYXRpb25SZXF1ZXN0Snd0IiwidmFsdWUiOiIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiYW55Iiwic2Vzc2lvblZhbHVlIjoiIiwic2Vzc2lvbkluZGV4IjoxMn0seyJrZXkiOiJhZHJBdXRoU3RhdGUiLCJ2YWx1ZSI6InRlc3RzdGF0ZSIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoidGVzdHN0YXRlIiwic2Vzc2lvbkluZGV4IjoxM30seyJrZXkiOiJwa2NlX2NvZGVfdmVyaWZpZXIiLCJ2YWx1ZSI6ImZhNTg5MzZmZjljMTNhODIzNzVmNGM0Y2JkOWM3Y2IxNTJiMDgyYjExMTJiNTUyNDJjNDBiYWI5IiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiJmYTU4OTM2ZmY5YzEzYTgyMzc1ZjRjNGNiZDljN2NiMTUyYjA4MmIxMTEyYjU1MjQyYzQwYmFiOSIsInNlc3Npb25JbmRleCI6MTR9LHsia2V5IjoiZGF0YWhvbGRlclBBUkp3dCIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImFueSIsInNlc3Npb25WYWx1ZSI6IiIsInNlc3Npb25JbmRleCI6MTV9LHsia2V5IjoiZGF0YWhvbGRlclBBUkFzc2VydGlvbkp3dCIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImFueSIsInNlc3Npb25WYWx1ZSI6IiIsInNlc3Npb25JbmRleCI6MTZ9LHsia2V5IjoiZGhQQVJJbml0aWF0ZVJlc3BSZXF1ZXN0VXJpIiwidmFsdWUiOiJ1cm46aWV0ZjpwYXJhbXM6b2F1dGgyOjYxZmE0Yzk2LTNmNzYtNDIyZS04M2I0LTAwZTRiYWQ5ODU0OSIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJhbnkiLCJzZXNzaW9uVmFsdWUiOiJ1cm46aWV0ZjpwYXJhbXM6b2F1dGgyOjYxZmE0Yzk2LTNmNzYtNDIyZS04M2I0LTAwZTRiYWQ5ODU0OSIsInNlc3Npb25JbmRleCI6MTd9LHsia2V5IjoiZGhQQVJJbml0aWF0ZVJlc3BFeHBpcmVzSW4iLCJ2YWx1ZSI6OTAsImVuYWJsZWQiOnRydWUsInR5cGUiOiJhbnkiLCJzZXNzaW9uVmFsdWUiOiI5MCIsInNlc3Npb25JbmRleCI6MTh9LHsia2V5IjoiZGF0YWhvbGRlckF1dGhvcml6ZVVSbCIsInZhbHVlIjoibG9jYWxob3N0OjgwODAvb2F1dGgyL2F1dGhvcml6ZSIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoibG9jYWxob3N0OjgwODAvb2F1dGgyL2F1dGhvcml6ZSIsInNlc3Npb25JbmRleCI6MTl9LHsia2V5Ijoic2NvcGUiLCJ2YWx1ZSI6ImZkeDp0cmFuc2FjdGlvbnM6cmVhZCUyMGZkeDphY2NvdW50YmFzaWM6cmVhZCUyMG9wZW5pZCUyMGZkeDpjdXN0b21lcnBlcnNvbmFsOnJlYWQlMjBmZHg6YWNjb3VudGRldGFpbGVkOnJlYWQlMjBmZHg6aW52ZXN0bWVudHM6cmVhZCUyMGZkeDpwYXltZW50c3VwcG9ydDpyZWFkJTIwZmR4OmFjY291bnRwYXltZW50czpyZWFkJTIwZmR4OmJpbGxzOnJlYWQlMjBmZHg6aW1hZ2VzOnJlYWQlMjBmZHg6cmV3YXJkczpyZWFkJTIwZmR4OnRheDpyZWFkJTIwZmR4OnN0YXRlbWVudHM6cmVhZCUyMGZkeDpjdXN0b21lcmNvbnRhY3Q6cmVhZCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiZmR4OnRyYW5zYWN0aW9uczpyZWFkJTIwZmR4OmFjY291bnRiYXNpYzpyZWFkJTIwb3BlbmlkJTIwZmR4OmN1c3RvbWVycGVyc29uYWw6cmVhZCUyMGZkeDphY2NvdW50ZGV0YWlsZWQ6cmVhZCUyMGZkeDppbnZlc3RtZW50czpyZWFkJTIwZmQuLi4iLCJzZXNzaW9uSW5kZXgiOjIwfSx7ImtleSI6InJlZnJlc2hUb2tlbiIsInZhbHVlIjoiT2tpNEozNnBVaHJyUXZkTE95OF9JcVhTZEVMc3ptcDJWYlowYk5KcUFvTFNGWEluNjMzU2psdFZneFFvVFo4NGJXWG5vbTY2QWtSRmR0VnI4SE9xaTN5YVl4Q1otNkN3dGRwYW5pUk5lMDB5Z0NGX285MVdPVzBLeTZ1cG9aV0oiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6Ik9raTRKMzZwVWhyclF2ZExPeThfSXFYU2RFTHN6bXAyVmJaMGJOSnFBb0xTRlhJbjYzM1NqbHRWZ3hRb1RaODRiV1hub202NkFrUkZkdFZyOEhPcWkzeWFZeENaLTZDd3RkcGFuaVJOZTAweWdDRl9vOTFXT1cwS3k2dXBvWldKIiwic2Vzc2lvbkluZGV4IjoyMX0seyJrZXkiOiJhY2Nlc3NUb2tlbiIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiIiLCJzZXNzaW9uSW5kZXgiOjIyfSx7ImtleSI6ImRhdGFob2xkZXJBVEFzc2VydGlvbkp3dCIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImFueSIsInNlc3Npb25WYWx1ZSI6IiIsInNlc3Npb25JbmRleCI6MjN9LHsia2V5IjoiZGF0YWhvbGRlclJBVEFzc2VydGlvbkp3dCIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImFueSIsInNlc3Npb25WYWx1ZSI6IiIsInNlc3Npb25JbmRleCI6MjR9LHsia2V5IjoicmVnaXN0cmF0aW9uX2FjY2Vzc190b2tlbiIsInZhbHVlIjoiIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImFueSIsInNlc3Npb25WYWx1ZSI6IiIsInNlc3Npb25JbmRleCI6MjV9LHsia2V5IjoicmVzb3VyY2VfaG9zdCIsInZhbHVlIjoibG9jYWxob3N0OjkwOTAiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6ImxvY2FsaG9zdDo5MDkwIiwic2Vzc2lvbkluZGV4IjoyNn0seyJrZXkiOiJhdXRob3JpemVfdG9rZW4iLCJ2YWx1ZSI6IiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiIiwic2Vzc2lvbkluZGV4IjoyN30seyJrZXkiOiJkZXBvc2l0X2FjY18xIiwidmFsdWUiOiIxMDAwMSIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiMTAwMDEiLCJzZXNzaW9uSW5kZXgiOjI4fSx7ImtleSI6ImxvYW5fYWNjXzEiLCJ2YWx1ZSI6IjIwMDAxIiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiIyMDAwMSIsInNlc3Npb25JbmRleCI6Mjl9LHsia2V5IjoiaW52ZXN0bWVudF9hY2NfMSIsInZhbHVlIjoiMzc0NjI3MiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0Iiwic2Vzc2lvblZhbHVlIjoiMzc0NjI3MiIsInNlc3Npb25JbmRleCI6MzB9LHsia2V5IjoibG9jX2FjY18xIiwidmFsdWUiOiI1MzI2ODg0IiwiZW5hYmxlZCI6dHJ1ZSwidHlwZSI6ImRlZmF1bHQiLCJzZXNzaW9uVmFsdWUiOiI1MzI2ODg0Iiwic2Vzc2lvbkluZGV4IjozMX0seyJrZXkiOiJ1c2VyXzEiLCJ2YWx1ZSI6ImZkeHVzZXIiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6ImZkeHVzZXIiLCJzZXNzaW9uSW5kZXgiOjMyfSx7ImtleSI6ImNvbnNlbnRfYXV0aF90b2tlbiIsInZhbHVlIjoidGVzdF9hdXRoX2NvZGUiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6InRlc3RfYXV0aF9jb2RlIiwic2Vzc2lvbkluZGV4IjozM30seyJrZXkiOiJjb25zZW50SWQiLCJ2YWx1ZSI6IiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJhbnkiLCJzZXNzaW9uVmFsdWUiOiIiLCJzZXNzaW9uSW5kZXgiOjM0fV0=)

1. Run the request from Postman: `Authorize (via PAR+RAR)`.
2. Copy the login URL from the `PAR Authorize` request curl section.
3. Paste the login URL in your browser to start the consent journey.
4. Log in with a valid [user](https://developer.mastercard.com/fdx-dev-hub/documentation/implementation-checklist/#test-user-profiles) (fdxuser, fdxuser1, fdxuser2). After a successful login, you can select the accounts for which you want to give consent.
5. Once the account is selected, hit the submit button.
6. Upon successful consent, you'll receive a success message. Copy the authorization code (the "code" field) from the URL in the browser.
7. Paste the authorization code into the body of the Get Access Token request, under the "code" key.
8. Hit the `Get Access Token` request endpoint. You will get the authorization token.
9. Now you can access the resource API using this authorization token.

## Instructions for Building a Docker Image
1. Uncomment the following properties from [application.properties](https://github.com/Mastercard/Fdx-Mock-Auth-Server/blob/main/src/main/resources/application.properties) so that the authorization server can interact with the [resource server](https://github.com/Mastercard/Fdx-Mock-Resource-Server) running on the docker container.
   1. mock.res.server.baseurl=http://fdx.mock.resource.server:9090
   2. mock.res.server.userurl=http://fdx.mock.resource.server:9090/user
2. Navigate into the project's root directory which contains the [Dockerfile](https://github.com/Mastercard/Fdx-Mock-Auth-Server/blob/main/Dockerfile) & build the Docker image using the Docker build command.
   1. "docker build -t fdx-mock-auth-server ."
3. Verify that the Docker image was successfully created. You should see <image-name> listed in the output.
4. Since both servers will be running on Docker containers, their hosts will be localhost.
   Each Docker container runs in its own isolated network namespace. The localhost within docker1 refers to docker1 itself, not to docker2. They will not be able to interact with each other.
5. To establish communication between Docker containers (docker1 and docker2) using Docker's port mapping (publishing ports).
   Create a user-defined bridge network, make sure both containers are connected to the same network and that they can resolve each other's container names.
6. Commands to create a custom network and run the containers are :
   1. `docker network create my-network`
   2. `docker run -d --network=my-network -p 8080:8080 --name fdx.mock.auth.server fdx-mock-auth-server`
   3. `docker run -d --network=my-network -p 9090:9090 --name fdx.mock.resource.server fdx-mock-resource-server`

## License
This is an open-source project and does not have any specific licensing.

## Contact Information
For any queries, please post a comment on GitHub. We will look into it and get back to you.
