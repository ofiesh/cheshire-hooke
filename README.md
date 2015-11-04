# cheshire-hooke

A Clojure library designed to add support to cheshire to deserialize objects that contain UUID strings to java.lang.UUIDs

## Usage
```clojure
[cheshire-hooke 0.1.0]

(require '[cheshire-hooke.core :refer :all])
```

### String UUID -> java.util.UUID

```clojure
(require '[cheshire.core :refer [parse-string]])

;; initialize the uuid hook
(init-json-uuid)

;; parse some json that contains a uuid
(parse-string "{\"uuid\": \"8f9c7237-8511-48e0-9074-2ba188b5ea9b\"}")
```
