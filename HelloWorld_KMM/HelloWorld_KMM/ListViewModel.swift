//
//  ListViewModel.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 05.07.2022.
//

import Foundation
import hello_world
import KMPNativeCoroutinesAsync

struct Placeholder: Identifiable {
    let id: Int
    let title: String
}

@MainActor
final class ListViewModel: ObservableObject {
    @Published private(set) var placeholders: [PlaceholderResult] = []
    @Published private(set) var placeholders_: [Placeholder] = []
    
    private var repository = Repository()
    
    private var task: Task<(), Never>? = nil
        
    func startMonitoring() {
        task = Task { [weak self] in
            let stream = asyncStream(for: repository.placeholdersSwift)
            do {
                for try await placeholders in stream {
                    self?.placeholders = placeholders
                }
            } catch {
                self?.placeholders = []
            }
            self?.task = nil
        }
    }
    
    func stopMonitoring() {
        task?.cancel()
        task = nil
    }
    
}

final class ListViewModel_Preview: ObservableObject {
    @Published private(set) var placeholders: [PlaceholderResult] = []
    
    func startMonitoring() {}
    func stopMonitoring() {}
}

extension PlaceholderResult: Identifiable {}
