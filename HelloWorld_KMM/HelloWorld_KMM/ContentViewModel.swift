//
//  ContentViewModel.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 27.06.2022.
//

import Foundation
import hello_world
import SwiftUI

final class ContentViewModel: ObservableObject {
    @Published private(set) var placeholder: TestAPI.PlaceholderResult?
        
    func loadPlaceholder() async {
        let placeholder = try? await API().getPlaceholderAsync()
        
        DispatchQueue.main.sync {
            self.placeholder = placeholder
        }
    }
    
}
