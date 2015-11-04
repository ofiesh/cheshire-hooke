(ns cheshire-hooke.core-test
  (:require [clojure.test :refer :all]
            [cheshire-hooke.core :refer :all]
            [cheshire.core :refer [parse-string]])
  (:import [java.util UUID]))

(init-json-uuid)

(def uuid-string "8f9c7237-8511-48e0-9074-2ba188b5ea9b")
(def uuid (UUID/fromString "8f9c7237-8511-48e0-9074-2ba188b5ea9b"))
(def string-obj (str "{\"foo\": \"" uuid-string "\"}"))

(deftest parse-string-test
  (testing "testing parse-string"
    (is (= {"foo" 1} (parse-string "{\"foo\": 1}")))))

(deftest parse-uuid-test
  (testing "testing parse uuid"
    (is (= {"foo" uuid}
           (parse-string string-obj)))))

(deftest parse-complex-uuid-test
  (testing "testing parsing uuid in complex object"
    (is (= {"bar" {"foo" uuid}}
           (parse-string
            (str
             "{\"bar\":"
             string-obj
             "}"))))))
