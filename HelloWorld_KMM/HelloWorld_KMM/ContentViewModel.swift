//
//  ContentViewModel.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 27.06.2022.
//

import Foundation
import hello_world
import KMPNativeCoroutinesAsync

@MainActor
final class ContentViewModel: ObservableObject {
    @Published private(set) var greeting: String = Greeting().greeting()
    @Published private(set) var placeholder: PlaceholderResult?
    
    private var repository = Repository()
    
    private var task: Task<(), Never>? = nil
    
    func startMonitoring() {
        task = Task { [weak self] in
            repository.startMonitoring()
            let stream = asyncStream(for: repository.placeholderSwift)
            do {
                for try await placeholder in stream {
                    self?.placeholder = placeholder
                }
            } catch {
                self?.placeholder = nil
            }
            self?.task = nil
        }
    }
    
    func stopMonitoring() {
        repository.stopMonitoring()
        task?.cancel()
        task = nil
    }
    
}

final class ContentViewModel_Preview: ObservableObject {
    @Published private(set) var greeting: String = "Hello, iOS"
    @Published private(set) var placeholder: PlaceholderResult? = nil
    
    func startMonitoring() {}
    func stopMonitoring() {}
}
