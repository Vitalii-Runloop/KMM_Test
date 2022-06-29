//
//  ContentView.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 27.06.2022.
//

import SwiftUI
import hello_world

struct ContentView: View {
    @EnvironmentObject var viewModel: ContentViewModel
    
    var body: some View {
        NavigationView {
            
            VStack {
                Text(Greeting().greeting())
                    .padding()
                
                Text("""
        ID: \((viewModel.placeholder?.id).map { String($0) } ?? "N/A")
        UserID: \((viewModel.placeholder?.userId).map { String($0) } ?? "N/A")
        Title: \(viewModel.placeholder?.title ?? "N/A")
        Completed: \((viewModel.placeholder?.completed).map { String($0) } ?? "N/A")
        """)
            }
            .frame(alignment: .top)
            
        }
        .task {
            await viewModel.loadPlaceholder()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().environmentObject(ContentViewModel())
    }
}
