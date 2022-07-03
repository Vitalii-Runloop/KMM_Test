//
//  ContentView.swift
//  HelloWorld_KMM
//
//  Created by Vitalii on 27.06.2022.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var viewModel: ContentViewModel
    
    var body: some View {
        NavigationView {
            
            VStack {
                Text(viewModel.greeting)
                    .padding()
                
                Text("""
        ID: \((viewModel.placeholder?.id).map { String($0) } ?? "N/A")
        UserID: \((viewModel.placeholder?.userId).map { String($0) } ?? "N/A")
        Title: \(viewModel.placeholder?.title ?? "N/A")
        Completed: \((viewModel.placeholder?.completed).map { String($0) } ?? "N/A")
        """)
            }
            .frame(alignment: .top)
            
        }.onAppear {
            viewModel.startMonitoring()
        }.onDisappear {
            viewModel.stopMonitoring()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView().environmentObject(ContentViewModel())
    }
}
