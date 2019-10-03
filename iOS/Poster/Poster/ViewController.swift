//
//  ViewController.swift
//  Poster
//
//  Created by 이바울 on 13/09/2019.
//  Copyright © 2019 woolbro. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func hello(){
        print("Hello!")
        
        //add alert
        let alert = UIAlertController(title: "hello alert", message: "firstApp!!", preferredStyle: .alert) // alert
        let action = UIAlertAction(title: "ok", style: .default, handler: nil) // ok action
        alert.addAction(action) //alert, action binding
        
        present(alert,animated: true,completion: nil)
        
    }
    @IBAction func newHello(){
        print("this is new Hello!")
        
        //add alert
        let testalert = UIAlertController(title: "hello alert", message: "new iphone 11!!", preferredStyle: .alert) // alert
        let okaction = UIAlertAction(title: "ok", style: .default, handler: nil) // ok action
        testalert.addAction(okaction) //alert, action binding
        
        present(testalert,animated: true,completion: nil)
        
    }

}

