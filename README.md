
# News API

A simple Rest API to interact with GNews API and fetch articles with provided Search params.
Exposes a single GET handler `articles/v1` with accepting below query params.

| Search Param | Default Value | Mandatory |
|--------------|:-------------:|----------:|
| q            |     None      |       Yes |
| lang         |      Any      |        No |
| country      |      Any      |        No |
| max          |      10       |        No |
| in           |      Any      |        No |
| nullable     |      Any      |        No |
| from         |      Any      |        No |
| to           |      Any      |        No |
| page         |       1       |        No |
| expand       |      Any      |        No |

## Features

- Interacts with GNews API with feign Client
- Enabled `Caffine` Caching Mechanism to avoid making feign calls over and over.
- cache is expired to set at 120 seconds.
- G News Feign Client api key is access via secrets. (currently stored in application.yaml for convenience)

## Tech Stack

Java, Spring Boot, `Caffine` Cache & Feign.