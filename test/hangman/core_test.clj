(ns hangman.core-test
  (:require [clojure.test :refer :all]
            [hangman.core :refer :all]))

(deftest missing-letters-test
  (testing "All letters are present"
    (is (empty? (missing-letters "LEMON" #{"L" "E" "M" "O" "N"}))))
  (testing "One Letter is missing"
    (is (not-empty (missing-letters "LEMON" #{"L" "E" "M" "O"}))))
  (testing "All Letters are missing"
    (is (not-empty (missing-letters "LEMON" #{}))))
  (testing "All Letters are missing but with wrong guesses"
    (is (not-empty (missing-letters "LEMON" #{"A" "X" "Y" "W"}))))
  )

(deftest guessed-word?-test
  (testing "All letters are present"
    (is (true? (guessed-word? "LEMON" #{"L" "E" "M" "O" "N"}))))
  (testing "One Letter is missing"
    (is (false? (guessed-word? "LEMON" #{"L" "E" "M" "O"}))))
  (testing "All Letters are missing"
    (is (false? (guessed-word? "LEMON" #{}))))
  (testing "All Letters are missing but with wrong guesses"
    (is (false? (guessed-word? "LEMON" #{"A" "X" "Y" "W"}))))
  )
