(ns cheshire-hooke.core
  (:require [robert.hooke :refer :all]
            [cheshire.parse :refer :all])
  (:import [com.fasterxml.jackson.core JsonParser JsonToken]
           [java.util UUID]))

(defn is-uuid [str]
  (re-matches #"^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$" str))

(defn parse-uuid [f ^JsonParser jp key-fn bd? array-coerce-fn]
  (if-let [uuid-str (and (identical? (.getCurrentToken jp)
                             JsonToken/VALUE_STRING)
                         (is-uuid (.getText jp)))]
          (UUID/fromString uuid-str)
          (f ^JsonParser jp key-fn bd? array-coerce-fn)))

(defn init-json-uuid []
  (add-hook #'parse* #'parse-uuid))




