//
//  HelloWorld_KMMApp.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 27.06.2022.
//

import SwiftUI

@main
struct HelloWorld_KMMApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView().environmentObject(ContentViewModel())
        }
    }
}
