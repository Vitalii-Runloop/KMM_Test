//
//  API.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 27.06.2022.
//

import Foundation
import hello_world

final class API {
    
    func getPlaceholderAsync() async throws -> TestAPI.PlaceholderResult {
        return try await withCheckedThrowingContinuation { continuation in
            DispatchQueue.main.async {
                TestAPI().fetchPlaceholder { result, error in
                    if let result = result {
                        continuation.resume(returning: result)
                    }
                    if let error = error {
                        continuation.resume(throwing: error)
                    }
                }
            }
        }
    }
    
 }
