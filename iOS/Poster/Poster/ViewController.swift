//
//  ViewController.swift
//  Poster
//
//  Created by 이바울 on 13/09/2019.
//  Copyright © 2019 woolbro. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    var currentValue:Int = 0 //변ㅅ
    @IBOutlet weak var bountyLabel: UILabel! //레이블
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        refresh()
    }
    
    @IBAction func showAlert(){
        let message_value = "현상금은 $ \(currentValue) 입니다"
        
        let alert = UIAlertController(title: "현상금 Alert", message: message_value, preferredStyle: .alert) // alert
        let action = UIAlertAction(title: "ok", style: .default, handler: { action in
            self.refresh()
        }) // ok action
        alert.addAction(action) //alert, action binding
        present(alert,animated: true,completion: nil)
        
        
    }
    
    func refresh(){
        let randomNum = arc4random_uniform(1000000)+1
        currentValue = Int(randomNum)
        bountyLabel.text = "$ \(currentValue)"
    }
}

