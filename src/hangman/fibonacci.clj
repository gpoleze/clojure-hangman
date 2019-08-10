(ns hangman.fibonacci)

(defn fib [x]
  (if (<= x 0) 0
               (if (<= x 2) 1
                            (+ (fib (- x 1)) (fib (- x 2))))))
