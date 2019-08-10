(ns hangman.core)

(def max-number-lifes 6)
(declare game)

(defn game-over [message]
  (do
    (println message)
    (System/exit 0)
    )
  )

(defn lost [] ((game-over "You were hang!")))
(defn won [] (game-over "Congrats, you discovered the word!"))

(defn missing-letters [word guesses]
  (remove (fn [letter] (contains? guesses (str letter))) word)
  )

(defn was-word-guessed? [word guesses]
  (empty? (missing-letters word guesses))
  )

(defn read-letter! [] (read-line))

(defn is-guess-right? [word guess] (.contains word guess))

(defn evaluate-guess [guess lifes word guesses]
  (if (is-guess-right? word guess)
    (game lifes word (conj guesses guess))
    (game (dec lifes) word guesses)
    )
  )

(defn game [lifes word guesses] (
                                 (if (= lifes 0)
                                   (lost)
                                   (if (was-word-guessed? word guesses)
                                     (won)
                                     (evaluate-guess (read-letter!) lifes word guesses)
                                     )
                                   )
                                 )
  )

(defn -main
  "Start the game"
  [& args]
  (game max-number-lifes "lime" #{})
  )